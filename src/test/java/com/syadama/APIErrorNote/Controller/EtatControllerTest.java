package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Service.EtatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class EtatControllerTest {
    @Autowired
    EtatRepository etatRepository;
    @Autowired
    EtatService etatService;

    @Test
    void ajouter() {
        Etat etat= new Etat();
       etat.setStatus("EnCours");
        etatService.ajouter(etat);
    }

    @Test
    void modifer() {

        Etat etat = etatRepository.findById(1L).get();
        etat.setStatus("Initié");
        etatRepository.save(etat);
        assertNotEquals("NULL",etatRepository.findById(1L).get().getStatus());
    }

    @Test
    void voirSolution() {
    }
}