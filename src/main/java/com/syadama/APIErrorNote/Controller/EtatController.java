package com.syadama.APIErrorNote.Controller;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Etat")
public class EtatController {

    @Autowired
    private EtatService etatService;
    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @PostMapping("/ajouter/{email}/{password}")
    public String Ajouter(@PathVariable("email") String email, @PathVariable("password") String password, @RequestBody Etat etat){

        User user = userRepository.findByEmail(email);
        if (user != null){
            if (passwordEncoder().matches(password,user.getPassword())){
               if (user.getProfil().getLibelle().equals("Admin"))
               {
                   etatService.ajouter(etat);
                   return "Etat ajouté avec succes";
               }
               else {
                   return "Desolé vous n'êtes pas Administrateur du systeme";
               }

            }
            else{
                return "Mot de passe incorrect";
            }

        }
        else{
            return "Admin non trouvé";
        }

    }

    @PutMapping("/modifier/{id_etat}")
    public Etat modifer(@PathVariable Long id_etat, @RequestBody Etat etat){
        return etatService.modifier(id_etat,etat);
    }
    @GetMapping("/Voir")
    public List<Etat> voirSolution(){
        return etatService.lire();
    }
}
