package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import java.util.List;

public interface SocietePortIn {
    List<Societe> getAllSocietes();
    Societe getSocieteById(Long id);
    Societe addSociete(Societe societe);
    void deleteSocieteById(Long id);
}