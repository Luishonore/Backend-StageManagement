package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Depot;
import java.util.List;

public interface DepotPortOut {

    List<Depot> findAll();
    Depot findById(Integer idDepot);
    Depot save(Depot depot);
    void deleteById(Integer idDepot);
}
