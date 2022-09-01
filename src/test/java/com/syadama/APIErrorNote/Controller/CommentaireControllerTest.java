package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.SolutionRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.CommentaireService;
import com.syadama.APIErrorNote.Service.ProblemeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentaireControllerTest {
    @Autowired
    ProblemeService problemeService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SolutionRepository solutionRepository;
    @Autowired
    CommentaireService commentaireService;

    @Test
    public void ajouter() {
        Commentaire commentaire = new Commentaire();
        User user = userRepository.findByEmail("doulsy19@gmail.com");
        Probleme probleme = problemeService.trouverProblemeParTitre("bean");
        if (probleme != null) {
            Solution solution = solutionRepository.findByProbleme(probleme);
            if (user != null) {
                commentaire.setCommentaire("mali dfghjkfgh");
                commentaire.setSolution(solution);
                commentaire.setUser(user);
                commentaireService.ajouter(commentaire);
                System.out.println("Solution commenté avec succès");
            } else {
                System.out.println("Cet utilisateur n'existe pas veuiller vous enregistre !");
            }
        } else {
            System.out.println("Solution introuvable");
        }
    }
    @Test
    void modifer() {
    }

    @Test
    void supprimer() {
    }

    @Test
    void voirCommentaire() {
    }
}