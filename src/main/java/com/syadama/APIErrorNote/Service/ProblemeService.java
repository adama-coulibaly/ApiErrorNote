package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;

import java.util.List;

public interface ProblemeService {

    Probleme ajouter(Probleme probleme, String email);
    Probleme trouverProblemeParTitre(String titre);


    Probleme modifier(Long id_probleme, Probleme probleme);
    String supprimer(Long id_probleme);
    List<Probleme> lire();

    Object RechercheParMotCle(String motcle);

}
