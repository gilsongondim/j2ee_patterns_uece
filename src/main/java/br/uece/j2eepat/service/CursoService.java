package br.uece.j2eepat.service;

import br.uece.j2eepat.model.Curso;
import br.uece.j2eepat.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
     
    public List<Curso> findAll() {
    	
        return repository.findAll();
    }
     
    public Optional<Curso> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Curso save(Curso curso) {
        return repository.saveAndFlush(curso);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}