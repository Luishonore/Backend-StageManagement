package be.heh.dst.stagemanagement;

import be.heh.dst.stagemanagement.application.domain.service.AnnonceService;
import be.heh.dst.stagemanagement.application.domain.service.NoteService;
import be.heh.dst.stagemanagement.application.domain.service.SocieteService;
import be.heh.dst.stagemanagement.application.port.out.SocietePortOut;
import be.heh.dst.stagemanagement.application.port.out.NotePortOut;
import be.heh.dst.stagemanagement.application.port.out.AnnoncePortOut;
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
}
