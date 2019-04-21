package br.uece.j2eepat.controller;

import br.uece.j2eepat.model.Pergunta;
import br.uece.j2eepat.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping("/perguntas")
    public Page<Pergunta> getperguntas(Pageable pageable){
        return perguntaRepository.findAll(pageable);
    }

    @PostMapping("/perguntas")
    public Pergunta createpergunta(@Valid @RequestBody Pergunta pergunta){
        return perguntaRepository.save(pergunta);
    }

    @PutMapping("/perguntas/{perguntaId}")
    public Pergunta updatepergunta(@PathVariable Long perguntaId,
                                   @Valid @RequestBody Pergunta perguntaRequest){
        return perguntaRepository.findById(perguntaId)
                .map(pergunta -> {
                    pergunta.setTitle(perguntaRequest.getTitle());
                    pergunta.setDescription(perguntaRequest.getDescription());
                    return perguntaRepository.save(pergunta);
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }

    @DeleteMapping("/perguntas/{perguntaId}")
    public ResponseEntity<?> deletepergunta(@PathVariable Long perguntaId) {
        return perguntaRepository.findById(perguntaId)
                .map(pergunta -> {
                    perguntaRepository.delete(pergunta);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }
}
