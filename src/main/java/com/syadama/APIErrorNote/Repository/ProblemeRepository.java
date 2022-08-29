package com.syadama.APIErrorNote.Repository;

import com.syadama.APIErrorNote.Model.Probleme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemeRepository extends JpaRepository<Probleme, Long> {

    @Query(value = "SELECT * FROM probleme WHERE probleme.tire LIKE %?1%"+"OR probleme.description LIKE %?1%",nativeQuery = true)

    List<Probleme> RechercheParMotCle(String motCle);

}

