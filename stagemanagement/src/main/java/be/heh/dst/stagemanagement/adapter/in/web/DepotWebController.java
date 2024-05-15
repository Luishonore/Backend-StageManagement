package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Depot;
import be.heh.dst.stagemanagement.application.port.in.DepotPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/depot")
@Slf4j
public class DepotWebController {

    private final DepotPortIn depotPortIn;

    public DepotWebController(DepotPortIn depotPortIn) {
        this.depotPortIn = depotPortIn;
    }

    @GetMapping
    public List<Depot> getAllDepot() {
        return depotPortIn.getAllDepot();
    }

    @GetMapping("/{idDepot}")
    public Depot getDepotById(@PathVariable Integer idDepot) {
        return depotPortIn.getDepotByID(idDepot);
    }

    @PostMapping
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Superviseur')")
    public Depot addDepot(@RequestBody Depot depot) {
        return depotPortIn.addDepot(depot);
    }

    @DeleteMapping("/{idDepot}")
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Superviseur')")
    public void deleteDepotById(@PathVariable Integer idDepot) {
        depotPortIn.deleteDepotById(idDepot);
    }
}