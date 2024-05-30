package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.PropositionValider;
import java.util.List;

public interface PropositionValiderPortIn {
    List<PropositionValider> getAllValidatedPropositions();
    PropositionValider getValidatedPropositionByID(Integer id_proposition);
}
