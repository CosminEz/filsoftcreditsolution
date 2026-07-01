package com.filsoft.filsoftcreditsolutionproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nume")
    private String nume;

    @Column(name = "perioada")
    private Integer perioada;

    @Column(name = "fiscal_code")
    private Integer fiscalCode;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Rata> rataList;

    /**
     * Sets the rata list and keeps both sides of the relationship in sync,
     * so the foreign key column (credit_id) on each Rata is populated.
     */
    public void setRataList(List<Rata> rataList) {
        this.rataList = rataList;
        if (rataList != null) {
            rataList.forEach(rata -> rata.setCredit(this));
        }
    }

}
