package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Service.CommentaireService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("/Commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;


    @ApiOperation(value = "Ajouter un commentaire")
    @PostMapping("/ajouter")
    public Commentaire Ajouter(@RequestBody Commentaire commentaire){
        return commentaireService.ajouter(commentaire);
    }

    @ApiOperation(value = "Modifier un commentaire")
    @PutMapping("/modifier/{id_solution}")
    public Commentaire modifer(@PathVariable Long id_commentaire,@RequestBody Commentaire commentaire){
        return commentaireService.modifier(id_commentaire,commentaire);
    }
    @ApiOperation(value = "Supprimer un commentaire")
    @DeleteMapping("/supprimer/{id_commentaire}")
    public String supprimer(@PathVariable Long id_commentaire){
        return commentaireService.supprimer(id_commentaire);
    }

    @ApiOperation(value = "Voir un commentaire")
    @GetMapping("/Voir")
    public List<Commentaire> voirCommentaire(){
        return commentaireService.lire();
    }

}
