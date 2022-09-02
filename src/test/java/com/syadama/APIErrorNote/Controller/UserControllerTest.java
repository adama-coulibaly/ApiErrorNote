package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.ProfilRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProfilService;
import com.syadama.APIErrorNote.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
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
        user.setPrenom("Abdoulaye");
        user.setNom("SY");
        user.setPseudo("DoulSy");
        user.setEmail("doulsy94@gmail.com");
        user.setContact("94218444");
        user.setPassword("@Doulsy94");
        user.setProfil(profil);
        User userSave = userService.ajouter(user);
        assertNotNull(userSave);

/*
        assertEquals(user.getPrenom(), userSave.getPrenom());
        assertEquals(user.getNom(), userSave.getNom());
        assertEquals(user.getPseudo(), userSave.getPseudo());
        assertEquals(user.getEmail(), userSave.getEmail());
        assertEquals(user.getProfil(), userSave.getProfil());
        assertEquals(user.getPassword(), userSave.getPassword());
        assertEquals(user.getContact(), userSave.getContact());
        assertEquals(user.getPassword(), userSave.getPassword());
        */

    }

    @Test
    void modifer() {
        User user = userRepository.findById(1L).get();
        user.setNom("Sylla");
        user.setPrenom("Abdoul");
        user.setContact("94218444");
        user.setEmail("doulsy19@gmail.com");
        user.setPseudo("DoulSy");
        user.setPassword("@Doulsy9421");
        userRepository.save(user);
        assertNotEquals("SY",userRepository.findById(1L).get().getNom());
    }

    @Test
    void supprimer() {
        userRepository.deleteById(1L);
        assertThat(userRepository.existsById(1L)).isFalse();
    }

    @Test
    void voirSolution() {
    }
}