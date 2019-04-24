package br.uece.j2eepat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.uece.j2eepat.model.Pergunta;
import br.uece.j2eepat.service.PerguntaService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@RestController
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping("/apipergunta")
    public Page<Pergunta> getperguntas(Pageable pageable){
        return perguntaService.findAll(pageable);
    }

    @PostMapping("/apipergunta")
    public Pergunta createpergunta(@Valid @RequestBody Pergunta pergunta){
        return perguntaService.save(pergunta);
    }

    @PutMapping("/apipergunta/{perguntaId}")
    public Pergunta updatepergunta(@PathVariable Long perguntaId,
                                   @Valid @RequestBody Pergunta perguntaRequest){
        return perguntaService.findOne(perguntaId)
                .map(pergunta -> {
                    pergunta.setTitle(perguntaRequest.getTitle());
                    pergunta.setDescription(perguntaRequest.getDescription());
                    return perguntaService.save(pergunta);
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }

    @DeleteMapping("/apipergunta/{perguntaId}")
    public ResponseEntity<?> deletepergunta(@PathVariable Long perguntaId) {
        return perguntaService.findOne(perguntaId)
                .map(pergunta -> {
                    perguntaService.delete(perguntaId);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Pergunta nao encontrada com id: " + perguntaId));
    }


    @GetMapping("/pergunta")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/pergunta");
        mv.addObject("perguntas", perguntaService.findAllVTO());
        return mv;
    }

    @GetMapping("/perguntaAdd")
    public ModelAndView add(Pergunta pergunta) {

        ModelAndView mv = new ModelAndView("/perguntaAdd");
        mv.addObject("pergunta", pergunta);

        return mv;
    }


    @GetMapping("/perguntaAdd2")
    public ModelAndView add2(Optional<Pergunta> optional) {

        ModelAndView mv = new ModelAndView("/perguntaAdd");
        mv.addObject("pergunta", optional);

        return mv;
    }

    @GetMapping("/editpergunta/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add2(perguntaService.findOne(id));
    }

    @GetMapping("/deletepergunta/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        perguntaService.delete(id);

        return findAll();
    }


    @PostMapping("/savepergunta")
    public ModelAndView save(@Valid Pergunta pergunta, BindingResult result) {

        if(result.hasErrors()) {
            return add(pergunta);
        }

        perguntaService.save(pergunta);

        return findAll();
    }

}
