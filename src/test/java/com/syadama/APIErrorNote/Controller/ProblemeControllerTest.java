package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Repository.ProblemeRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProblemeControllerTest {

@Autowired
ProblemeRepository problemeRepository;
@Autowired
ProblemeService problemeService;
@Autowired
UserRepository userRepository;
@Autowired
    EtatRepository etatRepository;
    @Test
    void passwordEncoder() {
            }

    @Test
    void ajouter() {

        if (userRepository.findByEmail("doulsy94@gmail.com") != null) {
            Probleme probleme = new Probleme();
            Etat etat = new Etat();
            etat.setId_etat(1L);
            probleme.setId_probleme(1L);
            probleme.setTitre("Bean");
            probleme.setTechno_concerne("Java Spring boot");
            probleme.setDescription("Probleme de bean sur un projet");
            User user = userRepository.findByEmail("doulsy94@gmail.com");
            probleme.setEtat(etatRepository.save(etat));
            probleme.setUser(user);
            problemeRepository.save(probleme);
        }
    }
    @Test
    void modifer() {

    }

    @Test

    void supprimer() {
        problemeRepository.deleteById(2L);
        assertThat(problemeRepository.existsById(2L)).isFalse();
    }

    @Test
    void lire() {
    }

    @Test
    void rechercheMotcle() {
    }
}