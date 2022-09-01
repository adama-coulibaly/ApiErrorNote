package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.Profil;
import com.syadama.APIErrorNote.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByEmail(String email);
     User findByPassword(String password);




     User findByProfil(Profil profil);

}
