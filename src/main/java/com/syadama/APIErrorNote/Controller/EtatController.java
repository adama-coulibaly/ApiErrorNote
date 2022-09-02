package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Service.EtatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api
@RestController
@RequestMapping("/Etat")
public class EtatController {

    @Autowired
    private EtatService etatService;

    @ApiOperation(value = "Ajouter un Etat")
    @PostMapping("/ajouter")
    public Etat Ajouter(@RequestBody Etat etat){
        return etatService.ajouter(etat);
    }

    @ApiOperation(value = "Modifier etat")
    @PutMapping("/modifier/{id_etat}")
    public Etat modifer(@PathVariable Long id_etat, @RequestBody Etat etat){
        return etatService.modifier(id_etat,etat);
    }
    @ApiOperation(value = "Voir etat")
    @GetMapping("/Voir")
    public List<Etat> voirSolution(){
        return etatService.lire();
    }
}
