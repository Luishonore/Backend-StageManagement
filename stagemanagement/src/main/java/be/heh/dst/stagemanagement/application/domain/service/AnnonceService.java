package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.Annonce;
import be.heh.dst.stagemanagement.application.port.in.AnnoncePortIn;
import be.heh.dst.stagemanagement.application.port.out.AnnoncePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceService implements AnnoncePortIn{

    private final AnnoncePortOut annoncePortOut;

    @Autowired
    public AnnonceService(AnnoncePortOut annoncePortOut) {
        this.annoncePortOut = annoncePortOut;
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annoncePortOut.findAll();
    }

    @Override
    public Annonce getAnnonceById(Integer idAnnonce) {
        return annoncePortOut.findById(idAnnonce);
    }

    @Override
    public Annonce addAnnonce(Annonce annonce) {
        return annoncePortOut.save(annonce);
    }

    @Override
    public void deleteAnnonceById(Integer idAnnonce) {
        annoncePortOut.deleteById(idAnnonce);
    }

}