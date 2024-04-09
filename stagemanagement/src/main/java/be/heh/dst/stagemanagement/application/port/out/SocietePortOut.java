package be.heh.dst.stagemanagement.application.port.out;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import java.util.List;

public interface SocietePortOut {
    List<Societe> findAll();
    List<Societe> findByName(String nom);
    Societe save(Societe societe);
    void deleteById(Integer idSociete);
}