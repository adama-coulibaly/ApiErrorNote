package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

  }
