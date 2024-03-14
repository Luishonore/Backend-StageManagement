package be.heh.dst.stagemanagement.teststructure;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.domain.service.SocieteService;
import be.heh.dst.stagemanagement.application.port.out.SocietePortOut;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSociete {
    @Test
    public void testGetAllSocietes() {
        // Initialisation des données
        Societe societe1 = new Societe(1, "Société 1", "1","rue du test","0001","Testing","0123456789","test1@gmail.com","testeur");
        Societe societe2 = new Societe(2, "Société 2", "2","rue du test","0001","Testing","9876543210","test2@gmail.com","testeur");
        List<Societe> expectedSocietes = Arrays.asList(societe1, societe2);

        // Mocker le port de sortie
        SocietePortOut mockSocietePortOut = Mockito.mock(SocietePortOut.class);
        Mockito.when(mockSocietePortOut.findAll()).thenReturn(expectedSocietes);

        // Création du service à tester
        SocieteService societeService = new SocieteService(mockSocietePortOut);

        // Appel de la méthode à tester
        List<Societe> actualSocietes = societeService.getAllSocietes();

        // Assertion
        assertEquals(expectedSocietes, actualSocietes);

    }

    @Test
    public void testGetSocieteByName() {
        // Initialisation des données
        String nom = "Société de test";
        Societe expectedSociete = new Societe(1, nom, "1","rue du test","0001","Testing","0123456789","test1@gmail.com","testeur");
        List<Societe> expectedList = List.of(expectedSociete);

        // Mocker le port de sortie
        SocietePortOut mockSocietePortOut = Mockito.mock(SocietePortOut.class);
        Mockito.when(mockSocietePortOut.findByName(nom)).thenReturn(expectedList);

        // Création du service à tester
        SocieteService societeService = new SocieteService(mockSocietePortOut);

        // Appel de la méthode à tester
        List<Societe> actualList = societeService.getSocieteByName(nom);

        // Assertion
        assertEquals(expectedList, actualList);
    }


    @Test
    public void testAddSociete() {
        // Initialisation des données
        Societe newSociete = new Societe(null, "Société 3", "3","rue du test","0001","Testing","0123456789","test1@gmail.com","testeur");
        Societe expectedSociete = new Societe(3, "Société 3", "3", "rue du test","0001","Testing","0123456789","test1@gmail.com","testeur");

        // Mocker le port de sortie
        SocietePortOut mockSocietePortOut = Mockito.mock(SocietePortOut.class);
        Mockito.when(mockSocietePortOut.save(newSociete)).thenReturn(expectedSociete);

        // Création du service à tester
        SocieteService societeService = new SocieteService(mockSocietePortOut);

        // Appel de la méthode à tester
        Societe actualSociete = societeService.addSociete(newSociete);

        // Assertion
        assertEquals(expectedSociete, actualSociete);
    }

    @Test
    public void testDeleteSocieteById() {
        // Initialisation des données
        Integer id = 1;

        // Mocker le port de sortie
        SocietePortOut mockSocietePortOut = Mockito.mock(SocietePortOut.class);
        Mockito.doNothing().when(mockSocietePortOut).deleteById(id);

        // Création du service à tester
        SocieteService societeService = new SocieteService(mockSocietePortOut);

        // Appel de la méthode à tester
        societeService.deleteSocieteById(id);

        // Assertion
        Mockito.verify(mockSocietePortOut).deleteById(id);
    }
}