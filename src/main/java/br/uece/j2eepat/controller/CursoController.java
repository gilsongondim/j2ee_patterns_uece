package br.uece.j2eepat.controller;

import br.uece.j2eepat.model.Curso;
import br.uece.j2eepat.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CursoController {
     
    @Autowired
    private CursoService service;
     
    @GetMapping("/curso")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/curso");
        mv.addObject("cursos", service.findAll());
         
        return mv;
    }
     
    @GetMapping("/cursoAdd")
    public ModelAndView add(Curso curso) {
         
        ModelAndView mv = new ModelAndView("/cursoAdd");
        mv.addObject("curso", curso);
        mv.addObject("cursos", service.findAll());
         
        return mv;
    }
    
    
    @GetMapping("/cursoAdd2")
    public ModelAndView add2(Optional<Curso> optional) {
         
        ModelAndView mv = new ModelAndView("/cursoAdd");
        mv.addObject("curso", optional);
         
        return mv;
    }
     
    @GetMapping("/editCurso/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add2(service.findOne(id));
    }
     
    @GetMapping("/deleteCurso/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        service.delete(id);
         
        return findAll();
    }
 
    @PostMapping("/saveCurso")
    public ModelAndView save(@Valid Curso curso, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(curso);
        }
         
        service.save(curso);
         
        return findAll();
    }
     
}