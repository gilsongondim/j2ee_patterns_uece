package br.uece.j2eepat.vto;

public class AlunoVTO {
	private Long id;
	private String nome;
	private Integer numeroMatricula;
	
	public AlunoVTO(Long id, String nome, Integer numeroMat) {
		this.id = id;
		this.nome = nome;
		this.numeroMatricula = numeroMat;
	}
	
	
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
}
