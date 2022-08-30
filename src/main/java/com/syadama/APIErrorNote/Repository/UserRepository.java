package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);

     User findByProfil(Profil profil);

}
