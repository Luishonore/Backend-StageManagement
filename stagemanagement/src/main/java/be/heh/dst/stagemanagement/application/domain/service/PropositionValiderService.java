package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.PropositionValider;
import be.heh.dst.stagemanagement.application.port.in.PropositionValiderPortIn;
import be.heh.dst.stagemanagement.application.port.out.PropositionValiderPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropositionValiderService implements PropositionValiderPortIn {

    private final PropositionValiderPortOut propositionValiderPortOut;

    @Autowired
    public PropositionValiderService(PropositionValiderPortOut propositionValiderPortOut) {
        this.propositionValiderPortOut = propositionValiderPortOut;
    }

    @Override
    public List<PropositionValider> getAllValidatedPropositions() {
        return propositionValiderPortOut.findAllValidated();
    }

    @Override
    public PropositionValider getValidatedPropositionByID(Integer id_proposition) {
        return propositionValiderPortOut.findValidatedById(id_proposition);
    }
}
