package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.port.in.SocietePortIn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "societe")
@Slf4j
public class SocieteWebController {

    //logs
    private static final Logger logger = LoggerFactory.getLogger(SocieteWebController.class);
    private final SocietePortIn societePortIn;
    public SocieteWebController(SocietePortIn societePortIn) {
        this.societePortIn = societePortIn;
    }

    @GetMapping
    public List<Societe> getAllSocietes() {
        logger.debug("Appel de la méthode getAllSocietes()");
        return societePortIn.getAllSocietes();
    }

    @GetMapping("/{nom}")
    public List<Societe> getSocieteByName(@PathVariable String nom) {
        logger.debug("Appel de la méthode getSocieteByName()");
        return societePortIn.getSocieteByName(nom);
    }

    @PostMapping
    public Societe addSociete(@RequestBody Societe societe) {
        logger.debug("Appel de la méthode addSociete()");
        return societePortIn.addSociete(societe);
    }

    @DeleteMapping("/{id}")
    public void deleteSocieteById(@PathVariable Integer id) {
        logger.debug("Appel de la méthode deleteSocieteById()");
        societePortIn.deleteSocieteById(id);
    }
}