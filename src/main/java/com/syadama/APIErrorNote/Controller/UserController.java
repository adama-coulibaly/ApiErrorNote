package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProfilService;
import com.syadama.APIErrorNote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfilService profilService;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/ajouter")
    public String Ajouter(@RequestBody User user){
        if (userRepository.findByEmail(user.getEmail()) != null){
            return "Utilisateur existe déja";
        }
        else {
            userService.ajouter(user);
            return "Utilisateur ajouter avec succes";

        }

    }

    @PutMapping("/modifier/{id_user}")
    public String modifer(@PathVariable Long id_user,@RequestBody User user){
         userService.modifier(id_user,user);
        return "Utilisateur modifier avec succes";
    }

    @DeleteMapping("/supprimer/{email}/{id_user}")
    public String supprimer(@PathVariable("email") String email, @PathVariable Long id_user){

         User user = userRepository.findByEmail(email);
         Long IdUserPost = user.getId_user();

            if (IdUserPost == id_user)
            {
                userService.supprimer(id_user);
                return "Vous etes utilisateurs de ce compte et vous l'avez supprimer";
            }
            else if(user.getProfil().getLibelle().equals("Admin"))
            {
                                  userService.supprimer(id_user);
                    return "Compte supprimer par l'administrateur avec succès";
                }

            else
            {
                return "Impossible de supprimer un compte d'autrui";
            }


    }

    @GetMapping("/Voir")
    public List<User> voirSolution(){
        return userService.lire();
    }


}
