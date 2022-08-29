package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @PostMapping("/ajouter")
    public Commentaire Ajouter(@RequestBody Commentaire commentaire){
        return commentaireService.ajouter(commentaire);
    }

    @PutMapping("/modifier")
    public Commentaire modifer(@PathVariable Long id_commentaire,@RequestBody Commentaire commentaire){
        return commentaireService.modifier(id_commentaire,commentaire);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id_commentaire){
        return commentaireService.supprimer(id_commentaire);
    }

    @GetMapping("/Voir")
    public List<Commentaire> voirCommentaire(){
        return commentaireService.lire();
    }

}
