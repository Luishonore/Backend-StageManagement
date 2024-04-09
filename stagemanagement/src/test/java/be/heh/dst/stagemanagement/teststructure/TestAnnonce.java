package be.heh.dst.stagemanagement.teststructure;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.domain.service.AnnonceService;
import be.heh.dst.stagemanagement.application.port.out.AnnoncePortOut;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAnnonce {

    @Test
    public void testGetAllAnnonces() {
        // Initialisation des données
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Annonce annonce1 = new Annonce(1,"ceci est un test","TEST","Jhonny","Test@gmail.com","0123456789","Sécurité",timestamp,1);
        Annonce annonce2 = new Annonce(2,"ceci est un test","TEST","Jhonny","Test@gmail.com","9876543210","Sécurité",timestamp,2);
        List<Annonce> expectedAnnonces = Arrays.asList(annonce1, annonce2);

        // Mocker le port de sortie
        AnnoncePortOut mockAnnoncePortOut = Mockito.mock(AnnoncePortOut.class);
        Mockito.when(mockAnnoncePortOut.findAll()).thenReturn(expectedAnnonces);

        // Création du service à tester
        AnnonceService annonceService = new AnnonceService(mockAnnoncePortOut);

        // Appel de la méthode à tester
        List<Annonce> actualAnnonces = annonceService.getAllAnnonces();

        // Assertion
        assertEquals(expectedAnnonces, actualAnnonces);
    }

    @Test
    public void testGetNoteById() {
        // Initialisation des données
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        int id = 1;
        Annonce expectedAnnonce = new Annonce(1,"ceci est un test","TEST","Jhonny","Test@gmail.com","0123456789","Sécurité", timestamp,1);

        // Mocker le port de sortie
        AnnoncePortOut mockAnnoncePortOut = Mockito.mock(AnnoncePortOut.class);
        Mockito.when(mockAnnoncePortOut.findById(id)).thenReturn(expectedAnnonce);

        // Création du service à tester
        AnnonceService annonceService = new AnnonceService(mockAnnoncePortOut);

        // Appel de la méthode à tester
        Annonce actualAnnonce = annonceService.getAnnonceById(id);

        // Assertion
        assertEquals(expectedAnnonce, actualAnnonce);
    }

    @Test
    public void testAddAnnonce() {
        // Initialisation des données
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Annonce newAnnonce = new Annonce(null,"ceci est un test","TEST","Jhonny","Test@gmail.com","0123456789","Sécurité",timestamp,1);
        Annonce expectedAnnonce = new Annonce(1,"ceci est un test","TEST","Jhonny","Test@gmail.com","0123456789","Sécurité",timestamp,1);

        // Mocker le port de sortie
        AnnoncePortOut mockAnnoncePortOut = Mockito.mock(AnnoncePortOut.class);
        Mockito.when(mockAnnoncePortOut.save(newAnnonce)).thenReturn(expectedAnnonce);

        // Création du service à tester
        AnnonceService annonceService = new AnnonceService(mockAnnoncePortOut);

        // Appel de la méthode à tester
        Annonce actualAnnonce = annonceService.addAnnonce(newAnnonce);

        // Assertion
        assertEquals(expectedAnnonce, actualAnnonce);
    }

    @Test
    public void testDeleteAnnonceById() {
        // Initialisation des données
        int id = 1;

        // Mocker le port de sortie
        AnnoncePortOut mockAnnoncePortOut = Mockito.mock(AnnoncePortOut.class);
        Mockito.doNothing().when(mockAnnoncePortOut).deleteById(id);

        // Création du service à tester
        AnnonceService annonceService = new AnnonceService(mockAnnoncePortOut);

        // Appel de la méthode à tester
        annonceService.deleteAnnonceById(id);

        // Assertion
        Mockito.verify(mockAnnoncePortOut).deleteById(id);
    }

}
