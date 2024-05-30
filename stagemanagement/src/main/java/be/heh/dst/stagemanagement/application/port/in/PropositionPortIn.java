package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import java.util.List;

public interface PropositionPortIn {
    // Table PROPOSITION_NON_VALIDER
    List<Proposition> getAllPropositions();
    Proposition getPropositionByID(Integer id_proposition);
    Proposition addProposition(Proposition proposition);
    void deletePropositionById(Integer id_proposition);
    // Validation des proposition
    void updateValidationSecretariat(Integer id_proposition, String newValue);
    void updateValidationCoordinateur(Integer id_proposition, String newValue);
}
