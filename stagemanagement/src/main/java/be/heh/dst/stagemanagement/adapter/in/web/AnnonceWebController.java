package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.port.in.AnnoncePortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/annonce")
@Slf4j
public class AnnonceWebController {

    private final AnnoncePortIn annoncePortIn;
    public AnnonceWebController(AnnoncePortIn annoncePortIn) {
        this.annoncePortIn = annoncePortIn;
    }

    @GetMapping
    public List<Annonce> getAllAnnonces() {
        return annoncePortIn.getAllAnnonces();
    }

    @GetMapping("/{idAnnonce}")
    public Annonce getAnnonceById(@PathVariable Integer idAnnonce) {
        return annoncePortIn.getAnnonceById(idAnnonce);
    }

    @PostMapping
    public Annonce addAnnonce(@RequestBody Annonce annonce) {
        return annoncePortIn.addAnnonce(annonce);
    }

    @DeleteMapping("/{idAnnonce}")
    public void deleteAnnonceById(@PathVariable Integer idAnnonce) {
        annoncePortIn.deleteAnnonceById(idAnnonce);
    }
}
