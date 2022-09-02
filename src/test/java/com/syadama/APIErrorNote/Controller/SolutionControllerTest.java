package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.ProblemeRepository;
import com.syadama.APIErrorNote.Repository.SolutionRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;tr
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SolutionControllerTest {
    @Autowired
    SolutionRepository solutionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProblemeRepository problemeRepository;

    @Test
    void ajouter() {
        User user = userRepository.findByEmail("doulsy94@gmail.com");
        Solution solution = new Solution();



        if ( user != null) {
            solution.setRessource("Intrenet");
            solution.setMethodologie_adopte("TYoutube Tuto");
            solution.setTemps_consacre("3min");

            Solution solutionSave = solutionRepository.save(solution);
            assertNotNull(solutionSave);

        }

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