package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("/Probleme")
public class ProblemeController {

    @Autowired
    private ProblemeService problemeService;
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository  userRepository;
    @Autowired
    EtatRepository etatRepository;

    @ApiOperation(value = "Ajouter un probleme")
    @PostMapping("/ajouter/{email}")
    public String Ajouter(@RequestBody Probleme probleme, @PathVariable("email") String email){

                System.out.println(email);
                User user = userRepository.findByEmail(email);

                probleme.getUser().setId_user(user.getId_user());
                problemeService.ajouter(probleme,email);
                return "Ajouter avec succes";
    }

    @ApiOperation(value = "Modifier un problème")
    @PutMapping("/Modifier/id_probleme")
    public Probleme modifier(@PathVariable Long id_probleme, @RequestBody Probleme probleme){
        return problemeService.modifier(id_probleme,probleme);
    }

    @ApiOperation(value = "Supprimer un problème")
    @DeleteMapping("/Supprimer/{id_probleme}")
    public  String supprimer(@PathVariable Long id_probleme){
        return problemeService.supprimer(id_probleme);
    }

    @ApiOperation(value = "Voir un problème")
    @GetMapping("/Voir")
    public List<Probleme> lire(){
        return problemeService.lire();
    }

    @ApiOperation(value = "Rechercher un problème")
    @GetMapping("/Recherche")
    public Object rechercheMotcle(@PathVariable String motCle){
        return problemeService.RechercheParMotCle(motCle);
    }



}

