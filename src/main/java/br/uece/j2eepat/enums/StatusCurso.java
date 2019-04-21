package br.uece.j2eepat.enums;

public enum StatusCurso {

	
	MATRICULADO(1),TRANCADO(2),JUBILADO(13);

    public int tipo;
  
    
    StatusCurso(int tipo) {
        this.tipo = tipo;
    }
}
