package com.filsoft.filsoftcreditsolutionproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
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
}
