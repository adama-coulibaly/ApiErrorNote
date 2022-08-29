package com.syadama.APIErrorNote.Controller;


import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/ajouter")
    public User Ajouter(@RequestBody User user){
        return userService.ajouter(user);
    }

    @PutMapping("/modifier")
    public User modifer(@PathVariable Long id_user,@RequestBody User user){
        return userService.modifier(id_user,user);
    }

    @DeleteMapping("/supprimer")
    public String supprimer(@PathVariable Long id_user){
        return userService.supprimer(id_user);
    }

    @GetMapping("/Voir")
    public List<User> voirSolution(){
        return userService.lire();
    }
}
