package be.heh.dst.stagemanagement.application.port.in;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import java.util.List;

public interface SocietePortIn {
    List<Societe> getAllSocietes();
    List<Societe> getSocieteByName(String nom);
    Societe addSociete(Societe societe);
    void deleteSocieteById(Integer idSociete);
}