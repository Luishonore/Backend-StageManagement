package be.heh.dst.stagemanagement.teststructure;

import be.heh.dst.stagemanagement.application.domain.model.Proposition;
import be.heh.dst.stagemanagement.application.domain.service.PropositionService;
import be.heh.dst.stagemanagement.application.port.out.PropositionPortOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestProposition {

    private PropositionService propositionService;
    private PropositionPortOut propositionPortOut;

    @BeforeEach
    void setUp() {
        propositionPortOut = Mockito.mock(PropositionPortOut.class);
        propositionService = new PropositionService(propositionPortOut);
    }

    @Test
    void getAllPropositions() {
        Proposition proposition1 = new Proposition(1, "Objectif 1", "Yes", "Q1", "2023/2024", "Nom1", "Prenom1", "email1@example.com",
                "0123456789", "N001", "RueOffi1", "N1", "1000", "VilleOffi1", "RueStage1", "N1", "2000",
                "VilleStage1", "Entreprise1", "Rue1", "N1", "3000", "Ville1", "0123456789", "Chef1", "emailchef1@example.com",
                "0123456789", "Maitre1", "emailmaitre1@example.com", "0123456789", "Valid", "Valid");

        Proposition proposition2 = new Proposition(2, "Objectif 2", "No", "Q2", "2023/2024", "Nom2", "Prenom2", "email2@example.com",
                "0987654321", "N002", "RueOffi2", "N2", "2000", "VilleOffi2", "RueStage2", "N2", "3000",
                "VilleStage2", "Entreprise2", "Rue2", "N2", "4000", "Ville2", "0987654321", "Chef2", "emailchef2@example.com",
                "0987654321", "Maitre2", "emailmaitre2@example.com", "0987654321", "Valid", "Valid");

        when(propositionPortOut.findAll()).thenReturn(Arrays.asList(proposition1, proposition2));

        List<Proposition> propositions = propositionService.getAllPropositions();

        assertNotNull(propositions);
        assertEquals(2, propositions.size());
        verify(propositionPortOut, times(1)).findAll();
    }

    @Test
    void getPropositionByID() {
        Proposition proposition = new Proposition(1, "Objectif 1", "Yes", "Q1", "2023/2024", "Nom1", "Prenom1", "email1@example.com",
                "0123456789", "N001", "RueOffi1", "N1", "1000", "VilleOffi1", "RueStage1", "N1", "2000",
                "VilleStage1", "Entreprise1", "Rue1", "N1", "3000", "Ville1", "0123456789", "Chef1", "emailchef1@example.com",
                "0123456789", "Maitre1", "emailmaitre1@example.com", "0123456789", "Valid", "Valid");

        when(propositionPortOut.findById(1)).thenReturn(proposition);

        Proposition foundProposition = propositionService.getPropositionByID(1);

        assertNotNull(foundProposition);
        assertEquals(1, foundProposition.getId_proposition());
        verify(propositionPortOut, times(1)).findById(1);
    }

    @Test
    void addProposition() {
        Proposition proposition = new Proposition(1, "Objectif 1", "Yes", "Q1", "2023/2024", "Nom1", "Prenom1", "email1@example.com",
                "0123456789", "N001", "RueOffi1", "N1", "1000", "VilleOffi1", "RueStage1", "N1", "2000",
                "VilleStage1", "Entreprise1", "Rue1", "N1", "3000", "Ville1", "0123456789", "Chef1", "emailchef1@example.com",
                "0123456789", "Maitre1", "emailmaitre1@example.com", "0123456789", "Valid", "Valid");

        when(propositionPortOut.save(any(Proposition.class))).thenReturn(proposition);

        Proposition savedProposition = propositionService.addProposition(proposition);

        assertNotNull(savedProposition);
        assertEquals(1, savedProposition.getId_proposition());
        verify(propositionPortOut, times(1)).save(any(Proposition.class));
    }

    @Test
    void deletePropositionById() {
        doNothing().when(propositionPortOut).deleteById(1);

        propositionService.deletePropositionById(1);

        verify(propositionPortOut, times(1)).deleteById(1);
    }

    @Test
    void updateValidationSecretariat() {
        doNothing().when(propositionPortOut).patchValidationSecretariat(1, "Validated");

        propositionService.updateValidationSecretariat(1, "Validated");

        verify(propositionPortOut, times(1)).patchValidationSecretariat(1, "Validated");
    }

    @Test
    void updateValidationCoordinateur() {
        doNothing().when(propositionPortOut).patchValidationCoordinateur(1, "Validated");

        propositionService.updateValidationCoordinateur(1, "Validated");

        verify(propositionPortOut, times(1)).patchValidationCoordinateur(1, "Validated");
    }
}
