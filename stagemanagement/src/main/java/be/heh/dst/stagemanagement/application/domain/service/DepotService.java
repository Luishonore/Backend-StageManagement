package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.Depot;
import be.heh.dst.stagemanagement.application.port.in.DepotPortIn;
import be.heh.dst.stagemanagement.application.port.out.DepotPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DepotService implements DepotPortIn {

    private final DepotPortOut depotPortOut;

    @Autowired
    public DepotService(DepotPortOut depotPortOut) {
        this.depotPortOut = depotPortOut;
    }

    @Override
    public List<Depot> getAllDepot(){
        return depotPortOut.findAll();
    }

    @Override
    public Depot getDepotByID(Integer idDepot){
        return depotPortOut.findById(idDepot);
    }

    @Override
    public Depot addDepot(Depot depot){
        return depotPortOut.save(depot);
    }

    @Override
    public void deleteDepotById(Integer idDepot){
        depotPortOut.deleteById(idDepot);
    }
}
