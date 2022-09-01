package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.*;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.SolutionService;
import com.syadama.APIErrorNote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/ajouter/{email}/{password}/{titre}")
    public String Ajouter(@RequestBody Solution solution,@PathVariable String email,@PathVariable String password, @PathVariable String titre){

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
                    if (passwordEncoder().matches(password,user.getPassword()))
                    {
                        solution.setProbleme(probleme);
                        Etat etat = new Etat();

                        etat.setId_etat(2L);

                        solution.getProbleme().setEtat(etat);

                        solutionService.ajouter(solution);
                        return "Solutionné avec succès ";
                    }
                    else{
                        return "Mot de passe incorrect";
                    }

                }
            }
            else {
                return "Ce probleme a été deja solutionné par"+user.getNom();
            }

        }else {
            return "Desolé ce probleme n'existe pas";
        }
    }

    @PutMapping("/modifier/{email}/{password}/{id_solution}")
    public String modifer(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable Long id_solution,@RequestBody Solution solution){

        User user = userRepository.findByEmail(email);

        if (user != null){
            if (passwordEncoder().matches(password,user.getPassword())){
                solutionService.modifier(id_solution,solution);
                return "Solution modifier avec succès";
            }
            else {
                return "Mot de passe incorrect";
            }

        }

            return "Utilisateur intouvable";
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
