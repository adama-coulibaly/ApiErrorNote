package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;

    @PostMapping("/ajouter")
    public Solution Ajouter(@RequestBody Solution solution){
        return solutionService.ajouter(solution);
    }

    @PutMapping("/modifier")
    public Solution modifer(@PathVariable Long id_solution,@RequestBody Solution solution){
        return solutionService.modifier(id_solution,solution);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id_solution){
        return solutionService.supprimer(id_solution);
    }

    @GetMapping("/Voir")
    public List<Solution> voirSolution(){
        return solutionService.lire();
    }
}
