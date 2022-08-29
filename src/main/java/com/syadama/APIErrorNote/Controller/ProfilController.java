package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Profil")
public class ProfilController {
    @Autowired
    private ProfilService profilService;

    @PostMapping("/ajouter")
    public Profil ajouterProfil(@RequestBody Profil profil){
        return profilService.ajouter(profil);
    }


}
