package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Probleme;

import java.util.List;

public interface ProblemeService {

    Probleme ajouter(Probleme probleme);
    Probleme modifier(Long id_probleme, Probleme probleme);
    String supprimer(Long id_probleme);
    List<Probleme> lire();

    Object RechercheParMotCle(String motcle);

}
