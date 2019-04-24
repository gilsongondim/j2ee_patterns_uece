package br.uece.j2eepat.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.uece.j2eepat.model.Resposta;
import br.uece.j2eepat.service.PerguntaService;
import br.uece.j2eepat.service.RespostaService;

@RestController
public class RespostaController {
    @Autowired
    private RespostaService respostaService;
    
    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/perguntas/{perguntaId}/respostas")
    public List<Resposta> getrespostasByperguntaId(@PathVariable Long perguntaId) {
        return respostaService.findByPerguntaId(perguntaId);
    }

    @PostMapping("/perguntas/{perguntaId}/respostas")
    public Resposta addresposta(@PathVariable Long perguntaId,
                              @Valid @RequestBody Resposta resposta) {
        return perguntaService.findOne(perguntaId)
                .map(pergunta -> {
                    resposta.setPergunta(pergunta);
                    return respostaService.save(resposta);
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId));
    }

    @PutMapping("/perguntas/{perguntaId}/respostas/{respostaId}")
    public Resposta updateresposta(@PathVariable Long perguntaId,
                                 @PathVariable Long respostaId,
                                 @Valid @RequestBody Resposta respostaRequest) {
        if(!perguntaService.existsById(perguntaId)) {
            throw new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId);
        }

        return respostaService.findOne(respostaId)
                .map(resposta -> {
                    resposta.setText(respostaRequest.getText());
                    return respostaService.save(resposta);
                }).orElseThrow(() -> new ResourceNotFoundException("Resposta nao encontrada com Id " + respostaId));
    }

    @DeleteMapping("/perguntas/{perguntaId}/respostas/{respostaId}")
    public ResponseEntity<?> deleteresposta(@PathVariable Long perguntaId,
                                          @PathVariable Long respostaId) {
        if(!perguntaService.existsById(perguntaId)) {
            throw new ResourceNotFoundException("Pergunta nao encontrada com Id " + perguntaId);
        }

        return respostaService.findOne(respostaId)
                .map(resposta -> {
                	respostaService.delete(respostaId);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Resposta nao encontrada com Id " + respostaId));

    }

}
