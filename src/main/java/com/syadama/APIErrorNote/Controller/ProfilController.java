package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Service.ProfilService;
import com.syadama.APIErrorNote.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api
@RestController
@RequestMapping("/Profil")
public class ProfilController {
    @Autowired
    private ProfilService profilService;
    private UserService userService;

    @ApiOperation(value = "Ajouter un profil")
    @PostMapping("/ajouter")
    public Profil ajouterProfil(@RequestBody Profil profil){
        return profilService.ajouter(profil);
    }

    /*
    @GetMapping("/Connexion/{profil}")
    public String seConnecter(@RequestBody User user, @PathVariable("profil") String profil1){
        Profil profil = profilService.trouverParLibelle(profil1);

        if (userService.seConnecter(user.getPseudo(),user.getPassword())){
            return "Conecter avec succes";

        }

        return "Utilisateur incorrecte";
    }

     */


}
