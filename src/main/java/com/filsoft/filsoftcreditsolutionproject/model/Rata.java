package com.filsoft.filsoftcreditsolutionproject.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rata")
public class Rata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    @ToString.Exclude
    private Credit credit;

    @Column(name = "principal")
    private Integer principal;

    @Column(name = "dobanda")
    private Integer dobanda;
}
