package br.uece.j2eepat.controller;

import br.uece.j2eepat.model.Resposta;
import br.uece.j2eepat.repository.RespostaRepository;
import br.uece.j2eepat.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RespostaController {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping("/perguntas/{perguntaId}/respostas")
    public List<Resposta> getrespostasByperguntaId(@PathVariable Long perguntaId) {
        return respostaRepository.findByPerguntaId(perguntaId);
    }

    @PostMapping("/perguntas/{perguntaId}/respostas")
    public Resposta addresposta(@PathVariable Long perguntaId,
                              @Valid @RequestBody Resposta resposta) {
        return perguntaRepository.findById(perguntaId)
                .map(pergunta -> {
                    resposta.setPergunta(pergunta);
                    return respostaRepository.save(resposta);
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId));
    }

    @PutMapping("/perguntas/{perguntaId}/respostas/{respostaId}")
    public Resposta updateresposta(@PathVariable Long perguntaId,
                                 @PathVariable Long respostaId,
                                 @Valid @RequestBody Resposta respostaRequest) {
        if(!perguntaRepository.existsById(perguntaId)) {
            throw new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId);
        }

        return respostaRepository.findById(respostaId)
                .map(resposta -> {
                    resposta.setText(respostaRequest.getText());
                    return respostaRepository.save(resposta);
                }).orElseThrow(() -> new ResourceNotFoundException("Resposta nao encontrada com Id " + respostaId));
    }

    @DeleteMapping("/perguntas/{perguntaId}/respostas/{respostaId}")
    public ResponseEntity<?> deleteresposta(@PathVariable Long perguntaId,
                                          @PathVariable Long respostaId) {
        if(!perguntaRepository.existsById(perguntaId)) {
            throw new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId);
        }

        return respostaRepository.findById(respostaId)
                .map(resposta -> {
                    respostaRepository.delete(resposta);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Resposta nao encontrada com Id " + respostaId));

    }

}
