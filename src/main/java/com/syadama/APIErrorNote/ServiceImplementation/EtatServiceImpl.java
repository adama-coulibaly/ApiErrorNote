package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.Etat;
import com.syadama.APIErrorNote.Repository.EtatRepository;
import com.syadama.APIErrorNote.Service.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtatServiceImpl implements EtatService {

    private final EtatRepository etatRepository;
    @Override
    public Etat ajouter(Etat etat) {
        return etatRepository.save(etat);
    }

    @Override
    public Etat modifier(Long id_etat, Etat etat) {
        return etatRepository.findById(id_etat)
                .map(etat1 -> {
                    etat1.setStatus(etat.getStatus());
                    return etatRepository.save(etat);
                }).orElseThrow(() -> new RuntimeException("Status non trouvé"));
    }

    @Override
    public List<Etat> lire() {
        return etatRepository.findAll();
    }
}
