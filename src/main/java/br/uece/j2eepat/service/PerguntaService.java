package br.uece.j2eepat.service;

import java.util.List;
import java.util.Optional;

import br.uece.j2eepat.vto.PerguntaVTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.uece.j2eepat.model.Pergunta;
import br.uece.j2eepat.repository.PerguntaRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Service
public class PerguntaService {
    @Autowired
    private PerguntaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<PerguntaVTO> findAllVTO() {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT NEW br.uece.j2eepat.vto.AlunoVTO(a.id, a.nome, a.numeroMatricula) ");
            sql.append(" FROM Aluno a ");
            Query query = entityManager.createQuery(sql.toString());
            return query.getResultList();

        } catch (NoResultException e) {
            return null;
        }
    }


}