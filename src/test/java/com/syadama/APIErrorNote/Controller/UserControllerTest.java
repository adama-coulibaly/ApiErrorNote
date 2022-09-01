package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.CommentaireRepository;
import com.syadama.APIErrorNote.Repository.ProfilRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProfilService;
import com.syadama.APIErrorNote.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    ProfilService profilService;
    @Autowired
    ProfilRepository profilRepository;

    @Test
    void ajouter() {
        User user = new User();
        Profil profil = new Profil();
        profil.setId_profil(1L);

        user.setPrenom("Abdoul");
        user.setNom("SY");
        user.setPseudo("DoulSy");
        user.setEmail("doulsy19@gmail.com");
        user.setContact("94218444");
        user.setPassword("@Doulsy94");
        user.setProfil(profil);

        User userSave = userService.ajouter(user);

        assertNotNull(userSave);
        assertEquals(user.getPrenom(), userSave.getPrenom());
        assertEquals(user.getNom(), userSave.getNom());
        assertEquals(user.getPseudo(), userSave.getPseudo());
        assertEquals(user.getEmail(), userSave.getEmail());
        assertEquals(user.getProfil(), userSave.getProfil());
        assertEquals(user.getPassword(), userSave.getPassword());
        assertEquals(user.getContact(), userSave.getContact());
        assertEquals(user.getPassword(), userSave.getPassword());
    }

    @Test
    void modifer() {
    }

    @Test
    void supprimer() {
    }

    @Test
    void voirSolution() {
    }
}