package br.uece.j2eepat.service;

import br.uece.j2eepat.model.Aluno;
import br.uece.j2eepat.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
     
    public List<Aluno> findAll() {
    	
        return repository.findAll();
    }
     
    public Optional<Aluno> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Aluno save(Aluno aluno) {
        return repository.saveAndFlush(aluno);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}