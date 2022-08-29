package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Model.Etat;

import java.util.List;

public interface EtatService {

    Etat ajouter(Etat etat);
    Etat modifier(Long id_etat,  Etat etat);
    List<Etat> lire();
}
