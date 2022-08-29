package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Service.ProblemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Probleme")
public class ProblemeController {

    @Autowired
    private ProblemeService problemeService;

    @PostMapping("/ajouter")
    public Probleme Ajouter(@RequestBody Probleme probleme){
        return problemeService.ajouter(probleme);
    }

    @PutMapping("/Modifieir/id_probleme")
    public Probleme modifier(@PathVariable Long id_probleme, @RequestBody Probleme probleme){
        return problemeService.modifier(id_probleme,probleme);
    }

    @DeleteMapping("/Supprimer/{id_probleme}")
    public  String supprimer(@PathVariable Long id_probleme){
        return problemeService.supprimer(id_probleme);
    }

    @GetMapping("/Voir")
    public List<Probleme> lire(){
        return problemeService.lire();
    }


    @GetMapping("/Recherche")
    public Object rechercheMotcle(@PathVariable String motCle){
        return problemeService.RechercheParMotCle(motCle);
    }



}

