package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.CommentaireRepository;
import com.syadama.APIErrorNote.Repository.SolutionRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.CommentaireService;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    SolutionRepository solutionRepository;
    @Autowired
    ProblemeService problemeService;
    @PostMapping("/ajouter/{email}/{titre}")
    public String Ajouter(@RequestBody Commentaire commentaire, @PathVariable String email,@PathVariable String titre){

        //Creation des  utilisateurs a travers ses emails
        User user = userRepository.findByEmail(email);
        //Appel des  problemes a travers leurs titres
        Probleme probleme = problemeService.trouverProblemeParTitre(titre);

        //On verifie si le probleme existe
        if (probleme != null){

            //On cherche la solution a travers le probleme
            Solution solution = solutionRepository.findByProbleme(probleme);

            //On verifie si la soluton existe
            if (solution != null){
                //On verifie si l'utilisateur en question existe
                if (user != null){
                    commentaire.setSolution(solution);
                    commentaire.setUser(user);
                    commentaireService.ajouter(commentaire);
                    return "Solution commenté avec succès";
                }else{
                    return "Cet utilisteur n'existe pas veuiller vous enregistre !";
                }

            }
            else {
                return "Solution introuvable";
            }


        }else {
            return "Solution intouvable";
        }


    }


    @PutMapping("/modifier/{id_solution}")
    public Commentaire modifer(@PathVariable Long id_commentaire,@RequestBody Commentaire commentaire){
        return commentaireService.modifier(id_commentaire,commentaire);
    }

    @DeleteMapping("/supprimer/{id_commentaire}")
    public String supprimer(@PathVariable Long id_commentaire){
        return commentaireService.supprimer(id_commentaire);
    }

    @GetMapping("/Voir")
    public List<Commentaire> voirCommentaire(){
        return commentaireService.lire();
    }

}
