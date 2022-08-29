package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User ajouter(User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifier(Long id_user, User user) {
        return userRepository.findById(id_user)
                .map(user1 -> {
                    user1.setNom(user.getNom());
                    user1.setPrenom(user.getPrenom());
                    user1.setContact(user.getContact());
                    user1.setPseudo(user.getPseudo());
                    user1.setPassword(user.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException("User non trouvé"));
    }

    @Override
    public String supprimer(Long id_user) {
        userRepository.deleteById(id_user);
        return "User supprimé";
    }

    @Override
    public List<User> lire() {
        return userRepository.findAll();
    }
}
