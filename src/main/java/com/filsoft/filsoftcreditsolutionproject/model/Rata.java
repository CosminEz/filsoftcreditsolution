package com.filsoft.filsoftcreditsolutionproject.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rata")
@IdClass(RataId.class)
public class Rata {

    @Id
    private Integer id;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_credit")
    @ToString.Exclude
    private Credit credit;

    @Column(name = "principal")
    private Integer principal;

    @Column(name = "dobanda")
    private Integer dobanda;

    @Column(name = "status")
    private Boolean status;
}
