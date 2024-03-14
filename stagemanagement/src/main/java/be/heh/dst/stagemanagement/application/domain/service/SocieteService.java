package be.heh.dst.stagemanagement.application.domain.service;

import be.heh.dst.stagemanagement.application.domain.model.Societe;
import be.heh.dst.stagemanagement.application.port.in.SocietePortIn;
import be.heh.dst.stagemanagement.application.port.out.SocietePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocieteService implements SocietePortIn {

    private final SocietePortOut societePortOut;

    @Autowired
    public SocieteService(SocietePortOut societePortOut) {
        this.societePortOut = societePortOut;
    }

    @Override
    public List<Societe> getAllSocietes() {
        return societePortOut.findAll();
    }

    @Override
    public List<Societe> getSocieteByName(String nom) {
        return societePortOut.findByName(nom);
    }

    @Override
    public Societe addSociete(Societe societe) {
        return societePortOut.save(societe);
    }

    @Override
    public void deleteSocieteById(Integer id) {
        societePortOut.deleteById(id);
    }
}
