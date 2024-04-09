package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import java.util.List;

public interface AnnoncePortOut {

    List<Annonce> findAll();
    Annonce findById(Integer idAnnonce);
    Annonce save(Annonce annonce);
    void deleteById(Integer idAnnonce);
}