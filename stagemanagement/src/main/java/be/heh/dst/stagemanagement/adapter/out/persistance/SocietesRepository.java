package be.heh.dst.stagemanagement.adapter.out.persistance;

import be.heh.dst.stagemanagement.application.domain.model.Societes;

import java.util.List;

public interface SocietesRepository {

    List<Societes> findAll();

    Societes findById(Long id);

    Societes save(Societes societe);

    void delete(Long id);

}
