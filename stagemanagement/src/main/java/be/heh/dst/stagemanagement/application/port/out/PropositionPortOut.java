package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import java.util.List;

public interface PropositionPortOut {
    // Table PROPOSITION_NON_VALIDER
    List<Proposition> findAll();
    Proposition findById(Integer id_proposition);
    Proposition save(Proposition proposition);
    void deleteById(Integer id_proposition);
    // Validation des proposition
    void patchValidationCoordinateur(Integer id_proposition, String newValue);
    void patchValidationSecretariat(Integer idProposition, String newValue);
}
