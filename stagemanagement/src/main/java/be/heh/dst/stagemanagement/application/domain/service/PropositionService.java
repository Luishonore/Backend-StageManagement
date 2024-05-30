package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import be.heh.dst.stagemanagement.application.port.in.PropositionPortIn;
import be.heh.dst.stagemanagement.application.port.out.PropositionPortOut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PropositionService implements PropositionPortIn {

    private final PropositionPortOut propositionPortOut;

    @Autowired
    public PropositionService(PropositionPortOut propositionPortOut) {
        this.propositionPortOut = propositionPortOut;
    }

    // Table PROPOSITION_NON_VALIDER
    @Override
    public List<Proposition> getAllPropositions() {
        return propositionPortOut.findAll();
    }

    @Override
    public Proposition getPropositionByID(Integer id_proposition) {
        return propositionPortOut.findById(id_proposition);
    }

    @Override
    public Proposition addProposition(Proposition proposition) {
        return propositionPortOut.save(proposition);
    }

    @Override
    public void deletePropositionById(Integer id_proposition) {
        propositionPortOut.deleteById(id_proposition);
    }

    // Validation des proposition
    @Override
    public void updateValidationSecretariat(Integer id_proposition, String newValue) {
        propositionPortOut.patchValidationSecretariat(id_proposition, newValue);
    }

    @Override
    public void updateValidationCoordinateur(Integer id_proposition, String newValue) {
        propositionPortOut.patchValidationCoordinateur(id_proposition, newValue);
    }
}
