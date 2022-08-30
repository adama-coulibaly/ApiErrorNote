package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.SolutionService;
import com.syadama.APIErrorNote.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("/Solution")
public class SolutionController {

    @Autowired
    private SolutionService solutionService;
    @Autowired
    private ProblemeService problemeService;
    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Ajouter une solution")
    @PostMapping("/ajouter/{email}/{titre}")
    public String Ajouter(@RequestBody Solution solution,@PathVariable String email, @PathVariable String titre){

        User user = userRepository.findByEmail(email);
        Probleme probleme = problemeService.trouverProblemeParTitre(titre);

        System.out.println("user: " + user + "problem: " + probleme.getTitre());

        if (probleme != null){
           // probleme.getUser().setId_user(user.getId_user());

            System.out.println("user poster" + user);

            Long IdProb = probleme.getId_probleme();
            Long IdUser = probleme.getUser().getId_user();
            Long IdUserPost = user.getId_user();

            System.out.println("Je suis id de Posteur "+IdUserPost);
            System.out.println("Je suis id de Solution "+IdUser);
            System.out.println("id probleme " + IdProb);

            if (solutionService.trouverParProbleme(probleme) == null){
                if (IdUserPost != IdUser){
                    return "Ce probleme n'est pas a vous !";
                }else {
                    solution.setProbleme(probleme);
                    solutionService.ajouter(solution);
                    return "Solutionné";
                }
            }
            else {
                return "Ce probleme a été deja solutionné";
            }

        }else {
            return "ce probleme n'existe pas";
        }
    }

    @ApiOperation(value = "Modifier une solution")
    @PutMapping("/modifier/{id_solution}")
    public Solution modifer(@PathVariable Long id_solution,@RequestBody Solution solution){
        return solutionService.modifier(id_solution,solution);
    }

    @ApiOperation(value = "Supprimer une solution")
    @DeleteMapping("/supprimer/{id_solution}")
    public String supprimer(@PathVariable Long id_solution){
        return solutionService.supprimer(id_solution);
    }

    @ApiOperation(value = "Voir une solution")
    @GetMapping("/Voir")
    public List<Solution> voirSolution(){
        return solutionService.lire();
    }
}
