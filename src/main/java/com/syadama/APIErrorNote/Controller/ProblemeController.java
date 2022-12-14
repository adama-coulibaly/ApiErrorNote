package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import com.syadama.APIErrorNote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Probleme")
public class ProblemeController {

    @Autowired
    private ProblemeService problemeService;
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository  userRepository;
    @Autowired
    EtatRepository etatRepository;

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/ajouter/{email}/{password}")
    public String Ajouter(@RequestBody Probleme probleme, @PathVariable("email") String email, @PathVariable("password") String password){


                User user = userRepository.findByEmail(email);
                if (user != null){
                    if (passwordEncoder().matches(password,user.getPassword())){
                        probleme.getUser().setId_user(user.getId_user());
                        problemeService.ajouter(probleme,email);
                        return "Ajouter avec succes";
                    }
                    else{
                        return "Mot de passe incorrect";
                    }

                }
                else{
                    return "Utilisateur non trouvé";
                }

    }

    @PutMapping("/modifier/{email}/{password}/{id_probleme}")
    public String modifer(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable Long id_probleme,@RequestBody Probleme probleme){

        User user = userRepository.findByEmail(email);


        if (user != null){
            if (passwordEncoder().matches(password,user.getPassword())){

                if (user.getEmail().equals(id_probleme))
                {
                    problemeService.modifier(id_probleme,probleme);
                    return "Solution modifier avec succès";
                }
                else {
                    System.out.println(user.getId_user()+"*********************************");
                    return "Desolé accès refusé";
                }


            }
            else {
                return "Mot de passe incorrect";
            }

        }
        else {
            return "Problem: Utilisateur intouvable";
        }
    }

    @DeleteMapping("/Supprimer/{id_probleme}")
    public  String supprimer(@PathVariable Long id_probleme){
        return problemeService.supprimer(id_probleme);
    }

    @GetMapping("/Voir")
    public List<Probleme> lire(){
        return problemeService.lire();
    }


    @GetMapping("/Recherche")
    public Object rechercheMotcle(@PathVariable String motCle){
        return problemeService.RechercheParMotCle(motCle);
    }



}

