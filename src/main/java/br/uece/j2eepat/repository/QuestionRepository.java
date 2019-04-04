package br.uece.j2eepat.repository;

import br.uece.j2eepat.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository extends JpaRepository<Question, Long> {
}
