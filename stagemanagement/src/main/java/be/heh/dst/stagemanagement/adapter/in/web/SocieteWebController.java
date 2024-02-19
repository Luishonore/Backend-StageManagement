package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.port.in.SocietePortIn;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "societe")
public class SocieteWebController {

    private final SocietePortIn societePortIn;
    public SocieteWebController(SocietePortIn societePortIn) {
        this.societePortIn = societePortIn;
    }

    @GetMapping
    public List<Societe> getAllSocietes() {
        return societePortIn.getAllSocietes();
    }

    @GetMapping("/{id}")
    public Societe getSocieteById(@PathVariable Long id) {
        return societePortIn.getSocieteById(id);
    }

    @PostMapping
    public Societe addSociete(@RequestBody Societe societe) {
        return societePortIn.addSociete(societe);
    }

    @DeleteMapping("/{id}")
    public void deleteSocieteById(@PathVariable Long id) {
        societePortIn.deleteSocieteById(id);
    }
}