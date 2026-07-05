package com.filsoft.filsoftcreditsolutionproject.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * Composite primary key for {@link Rata}, made of the rata's own id
 * and the owning credit's id (the id_credit foreign key).
 */
public class RataId implements Serializable {

    private Integer id;

    // Must match the name and type of the association field (Rata.credit -> Credit.id : UUID)
    private UUID credit;

    public RataId() {
    }

    public RataId(Integer id, UUID credit) {
        this.id = id;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getCredit() {
        return credit;
    }

    public void setCredit(UUID credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RataId rataId = (RataId) o;
        return Objects.equals(id, rataId.id) && Objects.equals(credit, rataId.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credit);
    }
}

