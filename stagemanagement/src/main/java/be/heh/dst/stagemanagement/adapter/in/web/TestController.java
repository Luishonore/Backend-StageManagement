package be.heh.dst.stagemanagement.adapter.in.web;

import be.heh.dst.stagemanagement.adapter.out.persistance.*;
import org.springframework.web.bind.annotation.*;
import be.heh.dst.stagemanagement.application.domain.model.Societes;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "societes")
public class TestController {
    private final SocietesRepository societesRepository;

    public TestController(SocietesRepository societesRepository)
    {
        this.societesRepository = societesRepository;
    }

    //GET ALL
    @GetMapping
    public List<Societes> getAllSocietes()
    {
        return societesRepository.findAll();
    }

    //GET  BY ID
    @GetMapping("/{id}")
    public Societes getSocieteById(@PathVariable Long id)
    {
        return societesRepository.findById(id);
    }

    //POST ADD
    @PostMapping
    public Societes createSociete(@RequestBody Societes societe)
    {
        return societesRepository.save(societe);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteSociete(@PathVariable Long id) {
        societesRepository.delete(id);
    }
}
