package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User ajouter(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword() ));


        return userRepository.save(user);
    }

    @Override
    public User modifier(Long id_user, User user) {

        return userRepository.findById(id_user)
                .map(user1 -> {
                    if (user.getNom() != null )
                    user1.setNom(user.getNom());
                    if (user.getPrenom() != null )
                    user1.setPrenom(user.getPrenom());
                    if (user.getContact() != null )
                    user1.setContact(user.getContact());
                    if (user.getPseudo() != null )
                    user1.setPseudo(user.getPseudo());
                    if (user.getEmail() != null )
                    user1.setEmail(user.getEmail());
                    if (user.getPassword() != null )
                    user1.setPassword(user.getPassword());

                    return userRepository.save(user1);
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
