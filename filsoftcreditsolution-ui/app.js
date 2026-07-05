const API = 'http://localhost:8080/api/credit';

/* ── Tabs ── */
document.querySelectorAll('.tab-btn').forEach(btn => {
  btn.addEventListener('click', () => {
    document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
    document.querySelectorAll('.tab-panel').forEach(p => p.classList.remove('active'));
    btn.classList.add('active');
    document.getElementById(btn.dataset.tab).classList.add('active');
  });
});

/* ── Helpers ── */
function fmt(n) {
  return Number(n).toLocaleString('ro-RO') + ' RON';
}

function showAlert(el, type, msg) {
  el.className = `alert alert-${type} visible`;
  el.innerHTML = `<span>${iconFor(type)}</span><span>${msg}</span>`;
}

function iconFor(type) {
  if (type === 'success') return '✓';
  if (type === 'error')   return '✕';
  return 'ℹ';
}

function spinner(btn, on) {
  const s = btn.querySelector('.spinner');
  btn.disabled = on;
  if (s) s.classList.toggle('visible', on);
}

/* ══════════════════════════════════════════
   TAB 1 — Creare Credit
══════════════════════════════════════════ */
const createForm  = document.getElementById('createForm');
const createAlert = document.getElementById('createAlert');
const createBtn   = document.getElementById('createBtn');
const copyIdBtn   = document.getElementById('copyIdBtn');

createForm.addEventListener('submit', async e => {
  e.preventDefault();

  // Validare
  let valid = true;
  createForm.querySelectorAll('input[required]').forEach(inp => {
    const err = inp.nextElementSibling?.nextElementSibling;
    if (!inp.value.trim()) {
      inp.classList.add('error');
      if (err) err.classList.add('visible');
      valid = false;
    } else {
      inp.classList.remove('error');
      if (err) err.classList.remove('visible');
    }
  });
  if (!valid) return;

  const payload = {
    nume:       createForm.nume.value.trim(),
    perioada:   parseInt(createForm.perioada.value),
    fiscalCode: parseInt(createForm.fiscalCode.value),
    dobanda:    parseInt(createForm.dobanda.value),
    suma:       parseInt(createForm.suma.value),
  };

  spinner(createBtn, true);
  createAlert.className = 'alert';

  try {
    const res = await fetch(`${API}/create`, {
      method:  'POST',
      headers: { 'Content-Type': 'application/json' },
      body:    JSON.stringify(payload),
    });

    const text = await res.text();

    if (!res.ok) throw new Error(text || `HTTP ${res.status}`);

    // Extrage UUID din răspuns "Credit created successfully with ID: <uuid>"
    const match = text.match(/([0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12})/i);
    const id = match ? match[1] : null;

    showAlert(createAlert, 'success',
      id
        ? `Credit creat cu succes! &nbsp;<code class="uuid-chip" id="newCreditId" title="Click pentru copiere">${id}</code>`
        : 'Credit creat cu succes!'
    );

    if (id) {
      document.getElementById('newCreditId')?.addEventListener('click', () => {
        navigator.clipboard.writeText(id);
        document.getElementById('newCreditId').textContent = 'Copiat!';
      });
      copyIdBtn.dataset.id = id;
      copyIdBtn.style.display = 'inline-flex';
    }

    createForm.reset();
  } catch (err) {
    showAlert(createAlert, 'error', 'Eroare: ' + err.message);
  } finally {
    spinner(createBtn, false);
  }
});

copyIdBtn.addEventListener('click', () => {
  const id = copyIdBtn.dataset.id;
  if (!id) return;
  navigator.clipboard.writeText(id);

  // Comutare automată pe tab-ul de vizualizare și precompletare
  document.querySelector('[data-tab="tab-view"]').click();
  document.getElementById('searchId').value = id;
  document.getElementById('searchBtn').click();
});

/* ══════════════════════════════════════════
   TAB 2 — Vizualizare Credit
══════════════════════════════════════════ */
const searchId    = document.getElementById('searchId');
const searchBtn   = document.getElementById('searchBtn');
const searchAlert = document.getElementById('searchAlert');
const creditPanel = document.getElementById('creditPanel');
const searchSpinner = document.getElementById('searchSpinner');

searchBtn.addEventListener('click', loadCredit);
searchId.addEventListener('keydown', e => { if (e.key === 'Enter') loadCredit(); });

async function loadCredit(idOverride) {
  const id = (idOverride ?? searchId.value).trim();
  if (idOverride) searchId.value = id;
  if (!id) {
    showAlert(searchAlert, 'error', 'Introdu un UUID valid.');
    return;
  }

  searchAlert.className = 'alert';
  creditPanel.innerHTML = '';
  searchSpinner.classList.add('visible');
  searchBtn.disabled = true;

  try {
    const res = await fetch(`${API}/get/${encodeURIComponent(id)}`);
    if (res.status === 404) throw new Error('Creditul nu a fost găsit.');
    if (!res.ok) throw new Error(`HTTP ${res.status}`);

    const credit = await res.json();
    renderCredit(credit);
  } catch (err) {
    showAlert(searchAlert, 'error', err.message);
    creditPanel.innerHTML = '';
  } finally {
    searchSpinner.classList.remove('visible');
    searchBtn.disabled = false;
  }
}

function renderCredit(c) {
  // Sortare rate descrescător după dobândă
  const rate = [...(c.rataList || [])].sort((a, b) => b.dobanda - a.dobanda);
  const maxDobanda = rate.length ? rate[0].dobanda : 1;

  const rataLunara = rate.length
    ? (rate[0].principal + rate[0].dobanda)
    : 0;

  creditPanel.innerHTML = `
    <div class="card">
      <div class="card-title">
        <svg width="18" height="18" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24"><rect x="2" y="7" width="20" height="14" rx="2"/><path d="M16 7V5a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v2"/></svg>
        Detalii Credit
      </div>

      <div class="credit-meta">
        <div class="meta-item">
          <span class="meta-label">Nume</span>
          <span class="meta-value">${esc(c.nume)}</span>
        </div>
        <div class="meta-item">
          <span class="meta-label">Perioadă</span>
          <span class="meta-value">${c.perioada} luni</span>
        </div>
        <div class="meta-item">
          <span class="meta-label">Cod fiscal</span>
          <span class="meta-value">${c.fiscalCode}</span>
        </div>
        <div class="meta-item">
          <span class="meta-label">ID</span>
          <span class="meta-value" style="font-size:.78rem;font-family:monospace">${c.id}</span>
        </div>
      </div>

      <div class="stats-row">
        <div class="stat-box green">
          <div class="stat-label">Principal total</div>
          <div class="stat-value">${fmt(c.principalTotal)}</div>
        </div>
        <div class="stat-box red">
          <div class="stat-label">Dobândă totală</div>
          <div class="stat-value">${fmt(c.dobandaTotala)}</div>
        </div>
        <div class="stat-box blue">
          <div class="stat-label">Total de rambursat</div>
          <div class="stat-value">${fmt(c.principalTotal + c.dobandaTotala)}</div>
        </div>
        <div class="stat-box blue">
          <div class="stat-label">Rată lunară</div>
          <div class="stat-value">${fmt(rataLunara)}</div>
        </div>
      </div>
    </div>

    <div class="card">
      <div class="card-title">
        <svg width="18" height="18" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24"><path d="M9 17H7A5 5 0 0 1 7 7h2"/><path d="M15 7h2a5 5 0 0 1 0 10h-2"/><line x1="8" y1="12" x2="16" y2="12"/></svg>
        Plan de rambursare
        <span style="font-size:.78rem;font-weight:400;color:var(--muted);margin-left:auto">
          ${rate.length} rate &nbsp;·&nbsp; sortate descrescător după dobândă
        </span>
      </div>

      <div class="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>#</th>
              <th>ID Rată</th>
              <th class="sorted">Dobândă (RON)</th>
              <th>Dobândă %</th>
              <th>Principal (RON)</th>
              <th>Total rată (RON)</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            ${rate.map((r, i) => {
              const total = r.principal + r.dobanda;
              const pct = maxDobanda > 0 ? Math.round((r.dobanda / maxDobanda) * 100) : 0;
              return `
              <tr>
                <td class="rank-cell">${i + 1}</td>
                <td><span class="uuid-chip">${r.id}</span></td>
                <td>
                  <strong>${r.dobanda.toLocaleString('ro-RO')}</strong>
                </td>
                <td class="bar-cell">
                  <div class="bar-bg"><div class="bar-fill" style="width:${pct}%"></div></div>
                  <small style="color:var(--muted);font-size:.75rem">${pct}%</small>
                </td>
                <td>${r.principal.toLocaleString('ro-RO')}</td>
                <td><span class="badge badge-blue">${total.toLocaleString('ro-RO')}</span></td>
                <td>${r.status
                  ? '<span class="badge badge-green">Plătit</span>'
                  : `<span class="badge badge-red">Neplătit</span>
                     <button type="button" class="btn btn-outline pay-rata-btn" style="height:28px;padding:0 12px;font-size:.78rem;margin-left:6px" data-credit-id="${c.id}" data-rata-id="${r.id}">Plătește</button>`}</td>
              </tr>`;
            }).join('')}
          </tbody>
        </table>
      </div>
    </div>
  `;

  creditPanel.querySelectorAll('.pay-rata-btn').forEach(btn => {
    btn.addEventListener('click', () => payRata(btn.dataset.creditId, btn.dataset.rataId, btn));
  });
}

async function payRata(creditId, rataId, btn) {
  btn.disabled = true;
  btn.textContent = 'Se procesează…';

  try {
    const res = await fetch(`${API}/${encodeURIComponent(creditId)}/${encodeURIComponent(rataId)}/pay`, {
      method: 'POST',
    });
    if (!res.ok) throw new Error(`HTTP ${res.status}`);

    await loadCredit(creditId);
  } catch (err) {
    showAlert(searchAlert, 'error', 'Eroare la plata ratei: ' + err.message);
    btn.disabled = false;
    btn.textContent = 'Plătește';
  }
}

function esc(str) {
  return String(str ?? '')
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;');
}

/* ══════════════════════════════════════════
   TAB 3 — Căutare Client (nume / cod fiscal)
══════════════════════════════════════════ */
const clientSearchForm    = document.getElementById('clientSearchForm');
const clientSearchAlert   = document.getElementById('clientSearchAlert');
const clientSearchBtn     = document.getElementById('clientSearchBtn');
const clientSearchResults = document.getElementById('clientSearchResults');

clientSearchForm.addEventListener('submit', async e => {
  e.preventDefault();

  const nume       = clientSearchForm.nume.value.trim();
  const fiscalCode = clientSearchForm.fiscalCode.value.trim();

  if (!nume && !fiscalCode) {
    showAlert(clientSearchAlert, 'error', 'Introdu un nume sau un cod fiscal.');
    clientSearchResults.innerHTML = '';
    return;
  }

  const params = new URLSearchParams();
  if (fiscalCode) params.set('fiscalCode', fiscalCode);
  else if (nume) params.set('nume', nume);

  clientSearchAlert.className = 'alert';
  clientSearchResults.innerHTML = '';
  spinner(clientSearchBtn, true);

  try {
    const res = await fetch(`${API}/search?${params.toString()}`);
    if (!res.ok) throw new Error(`HTTP ${res.status}`);

    const credits = await res.json();
    renderClientSearchResults(credits);
  } catch (err) {
    showAlert(clientSearchAlert, 'error', 'Eroare: ' + err.message);
  } finally {
    spinner(clientSearchBtn, false);
  }
});

function renderClientSearchResults(credits) {
  if (!credits.length) {
    showAlert(clientSearchAlert, 'info', 'Niciun credit găsit pentru criteriile introduse.');
    clientSearchResults.innerHTML = '';
    return;
  }

  clientSearchResults.innerHTML = `
    <div class="card">
      <div class="card-title">
        Rezultate
        <span style="font-size:.78rem;font-weight:400;color:var(--muted);margin-left:auto">
          ${credits.length} credit${credits.length === 1 ? '' : 'e'} găsit${credits.length === 1 ? '' : 'e'}
        </span>
      </div>

      <div class="table-wrapper">
        <table>
          <thead>
            <tr>
              <th>Nume</th>
              <th>Cod fiscal</th>
              <th>Perioadă</th>
              <th>Principal total (RON)</th>
              <th>Dobândă totală (RON)</th>
              <th>ID</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            ${credits.map(c => `
              <tr>
                <td>${esc(c.nume)}</td>
                <td>${c.fiscalCode}</td>
                <td>${c.perioada} luni</td>
                <td>${(c.principalTotal ?? 0).toLocaleString('ro-RO')}</td>
                <td>${(c.dobandaTotala ?? 0).toLocaleString('ro-RO')}</td>
                <td><span class="uuid-chip" title="${c.id}">${String(c.id).substring(0, 8)}…</span></td>
                <td><button type="button" class="btn btn-outline view-credit-btn" data-id="${c.id}">Detalii →</button></td>
              </tr>`).join('')}
          </tbody>
        </table>
      </div>
    </div>
  `;

  clientSearchResults.querySelectorAll('.view-credit-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      document.querySelector('[data-tab="tab-view"]').click();
      loadCredit(btn.dataset.id);
    });
  });
}
