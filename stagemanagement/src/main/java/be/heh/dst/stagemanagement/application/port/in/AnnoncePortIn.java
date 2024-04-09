package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.domain.model.Note;
import java.util.List;

public interface AnnoncePortIn {

    List<Annonce> getAllAnnonces();
    Annonce getAnnonceById(Integer idAnnonce);
    Annonce addAnnonce(Annonce annonce);
    void deleteAnnonceById(Integer idAnnonce);
}
