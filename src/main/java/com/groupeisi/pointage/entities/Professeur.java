package com.groupeisi.pointage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nom;
    @Column(nullable = false, length = 200)
    private String prenom;
    @Column(unique = true, nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 16)
    private String password;
    @Column(nullable = false)
    private int etat;
}
