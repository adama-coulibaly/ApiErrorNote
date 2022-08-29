package com.syadama.APIErrorNote.ServiceImplementation;

import com.syadama.APIErrorNote.Model.Solution;
import com.syadama.APIErrorNote.Repository.SolutionRepository;
import com.syadama.APIErrorNote.Service.SolutionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolutionServiceImpl implements SolutionService {
    private final SolutionRepository solutionRepository;

    @Override
    public Solution ajouter(Solution solution) {
        return solutionRepository.save(solution);
    }

    @Override
    public Solution modifier(Long id_solution, Solution solution) {
        return solutionRepository.findById(id_solution)
                .map(solution1 -> {
                    solution1.setRessource(solution.getRessource());
                    solution1.setMethodologie_adopte(solution.getMethodologie_adopte());
                    solution1.setTemps_consacre(solution.getTemps_consacre());
                    return solutionRepository.save(solution);
                }).orElseThrow(() -> new RuntimeException("Solution non trouvé"));
    }


    @Override
    public String supprimer(Long id_solution) {
        solutionRepository.deleteById(id_solution);
        return "Solution supprimé";
    }

    @Override
    public List<Solution> lire() {
        return solutionRepository.findAll();
    }
}
