package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.Solution;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SolutionService {

    Solution ajouter(Solution solution);
    Solution modifier(Long id_solution, Solution solution);
    String supprimer(Long id_solution);
    List<Solution> lire();

    Solution trouverParProbleme(Probleme probleme);
}
