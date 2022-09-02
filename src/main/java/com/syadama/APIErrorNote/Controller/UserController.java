package com.syadama.APIErrorNote.Controller;

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

    @DeleteMapping("/supprimer/{id_user}")
    public String supprimer(@PathVariable Long id_user){
        return userService.supprimer(id_user);
    }

    @GetMapping("/Voir")
    public List<User> voirSolution(){
        return userService.lire();
    }


}
