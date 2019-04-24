package br.uece.j2eepat.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uece.j2eepat.model.Resposta;
import br.uece.j2eepat.repository.RespostaRepository;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository repository;
    
    @PersistenceContext
    private EntityManager entityManager;
     
    public List<Resposta> findAll() {
    	
        return repository.findAll();
    }
     
    public Optional<Resposta> findOne(Long id) {
        return repository.findById(id);
    }
     
    public Resposta save(Resposta reposta) {
        return repository.saveAndFlush(reposta);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
	public List<Resposta> findByPerguntaId(Long perguntaId) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select r from Resposta r ");
			sql.append(" where 1 = 1 ");
			sql.append(" and r.pergunta.id =:perguntaId ");
			Query query = entityManager.createQuery(sql.toString());
			query.setParameter("perguntaId", perguntaId);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}