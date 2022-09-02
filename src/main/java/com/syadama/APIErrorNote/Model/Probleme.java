package com.syadama.APIErrorNote.Model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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


    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;
}
