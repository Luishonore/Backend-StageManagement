package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.PropositionValider;
import java.util.List;

public interface PropositionValiderPortOut {
    List<PropositionValider> findAllValidated();
    PropositionValider findValidatedById(Integer id_proposition);
}
