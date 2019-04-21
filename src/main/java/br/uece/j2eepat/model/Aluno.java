package br.uece.j2eepat.model;

import br.uece.j2eepat.enums.StatusCurso;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "aluno")
public class Aluno implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "aluno_seq")
    private Long id;
     
     
    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;
   
    
    @NotNull(message = "matricula é obrigatória")
    private Integer numeroMatricula;
    
    @NotNull(message = "semetre é obrigatória")
    private Integer semestre;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private StatusCurso status;
    
    @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL)
    private Curso curso;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Integer numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}


	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public StatusCurso getStatus() {
		return status;
	}

	public void setStatus(StatusCurso status) {
		this.status = status;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	
	
    
    
}