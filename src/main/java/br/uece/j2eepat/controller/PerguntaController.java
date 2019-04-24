package br.uece.j2eepat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.uece.j2eepat.model.Pergunta;
import br.uece.j2eepat.service.PerguntaService;


@RestController
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/perguntas")
    public Page<Pergunta> getperguntas(Pageable pageable){
        return perguntaService.findAll(pageable);
    }

    @PostMapping("/perguntas")
    public Pergunta createpergunta(@Valid @RequestBody Pergunta pergunta){
        return perguntaService.save(pergunta);
    }

    @PutMapping("/perguntas/{perguntaId}")
    public Pergunta updatepergunta(@PathVariable Long perguntaId,
                                   @Valid @RequestBody Pergunta perguntaRequest){
        return perguntaService.findOne(perguntaId)
                .map(pergunta -> {
                    pergunta.setTitle(perguntaRequest.getTitle());
                    pergunta.setDescription(perguntaRequest.getDescription());
                    return perguntaService.save(pergunta);
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }

    @DeleteMapping("/perguntas/{perguntaId}")
    public ResponseEntity<?> deletepergunta(@PathVariable Long perguntaId) {
        return perguntaService.findOne(perguntaId)
                .map(pergunta -> {
                    perguntaService.delete(perguntaId);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }
}
