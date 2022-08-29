package com.syadama.APIErrorNote.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_probleme;
    private String titre;
    private String description;
    private String techno_concerne;


    @ManyToOne
    @JoinColumn(name = "etat_id_etat")
    private Etat etat;

    @OneToOne
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;
}
