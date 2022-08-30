package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatRepository extends JpaRepository<Etat, Long> {

     // Etat findByEtat(String status);
}
