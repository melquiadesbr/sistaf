package br.mil.eb.sistaf.model;

public enum Mencao {
	
	INSUFICIENTE(0, "I"),
	REGULAR(1, "R"),
	BOM(2, "B"),
	MUITO_BOM(3, "MB"),
	EXCELENTE(4, "E"),
	SUFICIENTE(5, "S"),
	INEXISTENTE(6, "-");
	
	
	private int indice;
	private String descricao;
	
	Mencao(int indice,  String descricao){
		this.indice = indice;
		this.descricao = descricao;
	}

	public int getIndice() {
		return indice;
	}

	public String getDescricao() {
		return descricao;
	}

}