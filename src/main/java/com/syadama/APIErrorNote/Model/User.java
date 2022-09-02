package com.syadama.APIErrorNote.Model;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_user;
    private String nom;
    private String prenom;
    private String contact;
    private String pseudo;
    private String password;

    private String email;

    @ManyToOne
    @JoinColumn(name = "profil_id_profil")
    private Profil profil;

}
