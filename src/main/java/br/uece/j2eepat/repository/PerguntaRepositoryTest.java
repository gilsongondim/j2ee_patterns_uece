package br.uece.j2eepat.repository;

import br.uece.j2eepat.model.Pergunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

public class PerguntaRepositoryTest {

    private static final long ID_QUESTION1 = 11l;
    private static final long ID_QUESTION2 = 12l;

    @Autowired
    private PerguntaRepository perguntaRepository;

    //@Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        System.out.println(">> iniciando carda de dados");
        Pergunta q1 = new Pergunta();
        q1.setId(ID_QUESTION1);
        q1.setTitle("Perguntas de Programaçao");
        q1.setDescription("Qual a linguagem mais usada para ERP?");
        Pergunta q2 = new Pergunta();
        q2.setId(ID_QUESTION2);
        q2.setTitle("Perguntas de Programaçao");
        q2.setDescription("Qual compilador mair usado?");

        perguntaRepository.saveAndFlush(q1);
        perguntaRepository.saveAndFlush(q2);
    }

}
