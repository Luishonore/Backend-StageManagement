package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Depot;
import java.util.List;
public interface DepotPortIn {
    List<Depot> getAllDepot();
    Depot getDepotByID(Integer idDepot);
    Depot addDepot(Depot depot);
    void deleteDepotById(Integer idDepot);
}
