package com.syadama.APIErrorNote.ServiceImplementation;
import com.syadama.APIErrorNote.Model.Commentaire;
import com.syadama.APIErrorNote.Repository.CommentaireRepository;
import com.syadama.APIErrorNote.Service.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentaireServiceImpl implements CommentaireService {

    private final CommentaireRepository commentaireRepository;
    @Override
    public Commentaire ajouter(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire modifier(Long id_commentaire, Commentaire commentaire) {
        return commentaireRepository.findById(id_commentaire)
                .map(commentaire1 -> {
                   commentaire1.setCommentaire(commentaire.getCommentaire());
                   return commentaireRepository.save(commentaire);
                }).orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public String supprimer(Long id_commentaire) {
        commentaireRepository.deleteById(id_commentaire);
        return "Commentaire supprimé";
    }

    @Override
    public List<Commentaire> lire() {
        return commentaireRepository.findAll();
    }
}
