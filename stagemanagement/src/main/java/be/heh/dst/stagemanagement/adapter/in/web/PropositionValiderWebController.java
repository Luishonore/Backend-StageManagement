package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.PropositionValider;
import be.heh.dst.stagemanagement.application.port.in.PropositionValiderPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/proposition")
@Slf4j
public class PropositionValiderWebController {

    private final PropositionValiderPortIn propositionValiderPortIn;

    public PropositionValiderWebController(PropositionValiderPortIn propositionValiderPortIn) {
        this.propositionValiderPortIn = propositionValiderPortIn;
    }

    @GetMapping("/valider")
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Secretariat')")
    public List<PropositionValider> getAllValidatedPropositions() {
        return propositionValiderPortIn.getAllValidatedPropositions();
    }

    @GetMapping("/valider/{id_proposition}")
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Secretariat')")
    public PropositionValider getValidatedPropositionById(@PathVariable Integer id_proposition) {
        return propositionValiderPortIn.getValidatedPropositionByID(id_proposition);
    }
}
