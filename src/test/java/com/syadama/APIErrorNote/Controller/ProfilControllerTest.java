package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Service.ProfilService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfilControllerTest {
    @Autowired
    ProfilService profilService;

    @Test
    void ajouterProfil() {
        Profil profil = new Profil();
        profil.setLibelle("Admin");
        profilService.ajouter(profil);
    }


}