package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import be.heh.dst.stagemanagement.application.port.in.PropositionPortIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/proposition")
@Slf4j
public class PropositionWebController {

    private final PropositionPortIn propositionPortIn;

    public PropositionWebController(PropositionPortIn propositionPortIn) {
        this.propositionPortIn = propositionPortIn;
    }

    // Table PROPOSITION_NON_VALIDER
    @GetMapping
    public List<Proposition> getAllProposition() {
        return propositionPortIn.getAllPropositions();
    }

    @GetMapping("/{id_proposition}")
    public Proposition getPropositionById(@PathVariable Integer id_proposition) {
        return propositionPortIn.getPropositionByID(id_proposition);
    }

    @PostMapping
    @PreAuthorize("hasRole('Stagiaires')")
    public Proposition addProposition(@RequestBody Proposition proposition) {
        return propositionPortIn.addProposition(proposition);
    }

    @DeleteMapping("/{id_proposition}")
    @PreAuthorize("hasRole('Coordinateurs') or hasRole('Secretariat')")
    public void deletePropositionById(@PathVariable Integer id_proposition) {
        propositionPortIn.deletePropositionById(id_proposition);
    }

    // Validation des proposition
    @PatchMapping("/validecoordinateur/{id_proposition}")
    @PreAuthorize("hasRole('Coordinateurs')")
    public void patchValidationCoordinateur(@PathVariable Integer id_proposition, @RequestBody Map<String, String> requestBody) {
        String newValue = requestBody.get("newValue");
        propositionPortIn.updateValidationCoordinateur(id_proposition, newValue);
    }

    @PatchMapping("/validesecretariat/{id_proposition}")
    @PreAuthorize("hasRole('Secretariat')")
    public void patchValidationSecretariat(@PathVariable Integer id_proposition, @RequestBody Map<String, String> requestBody) {
        String newValue = requestBody.get("newValue");
        propositionPortIn.updateValidationSecretariat(id_proposition, newValue);
    }
}
