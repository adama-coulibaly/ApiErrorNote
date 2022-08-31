package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.*;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.SolutionService;
import com.syadama.APIErrorNote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;
    @Autowired
    private ProblemeService problemeService;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/ajouter/{email}/{titre}")
    public String Ajouter(@RequestBody Solution solution,@PathVariable String email, @PathVariable String titre){

        User user = userRepository.findByEmail(email);
        Probleme probleme = problemeService.trouverProblemeParTitre(titre);


        if (probleme != null){
            Long IdProb = probleme.getId_probleme();
            Long IdUser = probleme.getUser().getId_user();
            Long IdUserPost = user.getId_user();


            if (solutionService.trouverParProbleme(probleme) == null){
                if (IdUserPost != IdUser){
                    return "Ce probleme n'est pas a vous !";
                }else {
                    solution.setProbleme(probleme);
                    solutionService.ajouter(solution);
                    return "Solutionné avec succès";
                }
            }
            else {
                return "Ce probleme a été deja solutionné";
            }

        }else {
            return "Desolé ce probleme n'existe pas";
        }
    }

    @PutMapping("/modifier/{id_solution}")
    public Solution modifer(@PathVariable Long id_solution,@RequestBody Solution solution){
        return solutionService.modifier(id_solution,solution);
    }

    @DeleteMapping("/supprimer/{id_solution}")
    public String supprimer(@PathVariable Long id_solution){
        return solutionService.supprimer(id_solution);
    }

    @GetMapping("/Voir")
    public List<Solution> voirSolution(){
        return solutionService.lire();
    }
}
