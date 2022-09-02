package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Repository.CommentaireRepository;
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
    @Autowired
    CommentaireRepository commentaireRepository;

    /*
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
        }*/
    @Test
    void ajouter() {
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaire("Jean n'est pas gentil");
        commentaireRepository.save(commentaire);
    }


    @Test
    void modifier() {
        Commentaire commentaire = new Commentaire();
        commentaireRepository.findById(2L)
                .map(commentaire1 -> {
                    commentaire1.setCommentaire(commentaire.getCommentaire());
                    commentaire.setCommentaire("Jean est sympathique");
                    return commentaireRepository.save(commentaire);
                }).orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    @Test
    void supprimer() {
        Commentaire commentaire = new Commentaire();
        commentaire.setId_commentaire(3L);
        Commentaire commentaireSave = commentaireRepository.save(commentaire);
        commentaireRepository.deleteById(commentaireSave.getId_commentaire());
    }
}