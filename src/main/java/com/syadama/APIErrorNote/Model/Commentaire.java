package com.syadama.APIErrorNote.Model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_commentaire;
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "solution_id_solution")
    private Solution solution;

}
