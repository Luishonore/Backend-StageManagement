package be.heh.dst.stagemanagement;

import be.heh.dst.stagemanagement.application.domain.service.*;
import be.heh.dst.stagemanagement.application.port.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SocieteService societeService(SocietePortOut societePortOut) {
        return new SocieteService(societePortOut);
    }

    @Bean
    public NoteService noteService(NotePortOut notePortOut) {
        return new NoteService(notePortOut);
    }

    @Bean
    public AnnonceService annonceService(AnnoncePortOut annoncePortOut) {
        return new AnnonceService(annoncePortOut);
    }

    @Bean
    public DepotService depotService(DepotPortOut depotPortOut) {
        return new DepotService(depotPortOut);
    }

    @Bean
    public PropositionService propositionService(PropositionPortOut propositionPortOut) {
        return new PropositionService(propositionPortOut);
    }

    @Bean
    public PropositionValiderService propositionValiderService(PropositionValiderPortOut propositionValiderPortOut) {
        return new PropositionValiderService(propositionValiderPortOut);
    }
}
