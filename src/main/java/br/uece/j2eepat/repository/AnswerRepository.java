package br.uece.j2eepat.repository;

import br.uece.j2eepat.model.Answer;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepository extends JpaRepositoryExtension<Answer, Long> {
    List<Answer> findByQuestionId(Long questionId);
}
