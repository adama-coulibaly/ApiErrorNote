package com.syadama.APIErrorNote.Service;

import com.syadama.APIErrorNote.Model.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire ajouter(Commentaire commentaire);
    Commentaire modifier(Long id_commentaire, Commentaire commentaire);
    String supprimer(Long id_commentaire);
    List<Commentaire> lire();

}
