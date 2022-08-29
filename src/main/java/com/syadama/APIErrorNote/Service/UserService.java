package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;

import java.util.List;

public interface UserService {

    User ajouter(User user);
    User modifier(Long id_user, User user);
    String supprimer(Long id_user);
    List<User> lire();
}
