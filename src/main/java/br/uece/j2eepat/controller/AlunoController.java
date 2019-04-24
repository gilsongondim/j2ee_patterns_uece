package br.uece.j2eepat.controller;

import br.uece.j2eepat.enums.StatusCurso;
import br.uece.j2eepat.model.Aluno;
import br.uece.j2eepat.service.AlunoService;
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
public class AlunoController {
     
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private CursoService cursoService;
     
    @GetMapping("/aluno")
    public ModelAndView findAll() {
         
        ModelAndView mv = new ModelAndView("/aluno");
        mv.addObject("alunos", alunoService.findAllVTO());   
        return mv;
    }
     
    @GetMapping("/alunoAdd")
    public ModelAndView add(Aluno aluno) {
         
        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", aluno);
        mv.addObject("cursos", cursoService.findAll());
        mv.addObject("statusList", StatusCurso.values());
         
        return mv;
    }
    
    
    @GetMapping("/alunoAdd2")
    public ModelAndView add2(Optional<Aluno> optional) {
         
        ModelAndView mv = new ModelAndView("/alunoAdd");
        mv.addObject("aluno", optional);
        mv.addObject("cursos", cursoService.findAll());
        mv.addObject("statusList",StatusCurso.values());
         
        return mv;
    }
     
    @GetMapping("/editAluno/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
         
        return add2(alunoService.findOne(id));
    }
     
    @GetMapping("/deleteAluno/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
         
        alunoService.delete(id);
         
        return findAll();
    }
    
 
    @PostMapping("/saveAluno")
    public ModelAndView save(@Valid Aluno aluno, BindingResult result) {
         
        if(result.hasErrors()) {
            return add(aluno);
        }
         
        alunoService.save(aluno);
         
        return findAll();
    }
     
}