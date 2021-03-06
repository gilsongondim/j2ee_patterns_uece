package br.uece.j2eepat.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uece.j2eepat.model.Aluno;
import br.uece.j2eepat.repository.AlunoRepository;
import br.uece.j2eepat.vto.AlunoVTO;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;
    
    @PersistenceContext
    private EntityManager entityManager;
     
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

	public List<AlunoVTO> findAllVTO() {

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