package br.uece.j2eepat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.uece.j2eepat.model.Pergunta;
import br.uece.j2eepat.repository.PerguntaRepository;

@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;
     
    public List<Pergunta> findAll() {
        return repository.findAll();
    }
    
    public Page<Pergunta> findAll(Pageable pageable){
    	return repository.findAll(pageable);
    }
     
    public Optional<Pergunta> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Pergunta save(Pergunta pergunta) {
        return repository.saveAndFlush(pergunta);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    public boolean existsById(Long id) {
    	return repository.existsById(id);
    }

}