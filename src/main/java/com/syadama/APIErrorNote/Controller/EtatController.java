package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Etat")
public class EtatController {

    @Autowired
    private EtatService etatService;

    @PostMapping("/ajouter")
    public Etat Ajouter(@RequestBody Etat etat){
        return etatService.ajouter(etat);
    }

    @PutMapping("/modifier/{id_etat}")
    public Etat modifer(@PathVariable Long id_etat, @RequestBody Etat etat){
        return etatService.modifier(id_etat,etat);
    }
    @GetMapping("/Voir")
    public List<Etat> voirSolution(){
        return etatService.lire();
    }
}
