package br.uece.j2eepat.service;

import br.uece.j2eepat.model.Curso;
import br.uece.j2eepat.model.Resposta;
import br.uece.j2eepat.repository.CursoRepository;
import br.uece.j2eepat.vto.AlunoVTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
    
    @PersistenceContext
    private EntityManager entityManager;
     
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

	public List<Curso> findAllVTO() {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select NEW br.uece.j2eepat.vto.CursoVTO(c.id, c.nome, c.instituicaoEnsino) ");
			sql.append(" FROM Curso c ");
			Query query = entityManager.createQuery(sql.toString());
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}