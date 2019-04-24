package br.uece.j2eepat.vto;

public class CursoVTO {
	
	private Long id;
	private String nome;
	private String instituicaoEnsino;
	
	public CursoVTO(Long id, String nome, String instituicaoEnsino) {
		this.id = id;
		this.nome = nome;
		this.instituicaoEnsino = instituicaoEnsino;
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

	public String getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(String instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

}
