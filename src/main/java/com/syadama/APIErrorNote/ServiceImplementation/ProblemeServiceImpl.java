package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Model.Probleme;
import com.syadama.APIErrorNote.Model.User;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Repository.ProblemeRepository;
import com.syadama.APIErrorNote.Repository.UserRepository;
import com.syadama.APIErrorNote.Service.ProblemeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProblemeServiceImpl implements ProblemeService {

    @Autowired
    private final ProblemeRepository problemeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtatRepository etatRepository;
    @Override
    public Probleme ajouter(Probleme probleme, String email) {
        if (userRepository.findByEmail(email) != null){

            Etat etat = new Etat();

            User user = userRepository.findByEmail(email);
            etat.setId_etat(1L);
            probleme.setEtat(etat);

            probleme.getUser().setId_user(user.getId_user());

            return problemeRepository.save(probleme);
        }
        else {
                return null;
        }
      }

    @Override
    public Probleme trouverProblemeParTitre(String titre) {
        return problemeRepository.findByTitre(titre);
    }

    @Override
    public Probleme modifier(Long id_probleme, Probleme probleme) {
        return problemeRepository.findById(id_probleme)
                .map(probleme1 -> {
                    probleme1.setDescription(probleme.getDescription());
                    probleme1.setTitre(probleme.getTitre());
                    probleme1.setTechno_concerne(probleme.getTechno_concerne());
                    return problemeRepository.save(probleme);
                }).orElseThrow(() -> new RuntimeException("Problème non trouvé"));
    }

    @Override
    public String supprimer(Long id_probleme) {
        problemeRepository.deleteById(id_probleme);
        return "Problème supprimé";
    }

    @Override
    public List<Probleme> lire() {
        return problemeRepository.findAll();
    }

    @Override
    public Object RechercheParMotCle(String motcle) {

        if (motcle !=null){
            List<Probleme> retrouve = problemeRepository.RechercheParMotCle(motcle);
            System.out.println(retrouve);
            if (retrouve.size() != 0) {
                return retrouve;
            } else {
                return "Desole ce mot clé est introuvable";
            }
        }
        return problemeRepository.findAll();

    }
}
