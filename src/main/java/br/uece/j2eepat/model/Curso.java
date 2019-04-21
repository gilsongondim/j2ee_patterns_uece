package br.uece.j2eepat.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "curso")
public class Curso implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @SequenceGenerator(name = "curso_seq", sequenceName = "curso_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "curso_seq")
    private Long id;
     
    @Column(nullable = false, length = 10)
    @NotBlank(message = "Codigo é uma informação obrigatória.")
    private String cod;
     
    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String nome;
     
    @Column(nullable = false, length = 2000)
    @NotBlank(message = "Instituicao de Ensino é uma informação obrigatória.")
    private String instituicaoEnsino;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	
    
    
}