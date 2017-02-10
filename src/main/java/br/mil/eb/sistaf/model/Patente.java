package br.mil.eb.sistaf.model;

public enum Patente {
	
	SEM_PATENTE(0,"Sem Patente","SP"),
	MARECHAL(1,"Marechal","Mar"),
	GENERAL_EXERCITO(2,"General de Exército","Gen Ex"),
	GENERAL_DIVISAO(3,"General de Divisão","Gen Div"),
	GENERAL_BRIGADA(4,"General de Brigada","Gen Bda"),
	CORONEL (5,"Coronel", "Cel"),
	TENETE_CORONEL(6,"Tenente Coronel", "TC"),
	MAJOR(7,"Major", "Maj"),
	CAPITAO(8,"Capitão", "Cap"),
	PRIMEIRO_TENENTE(9, "Primeiro Tenente", "1º Ten"),
	SEGUNDO_TENENTE(10, "Segundo Tenente", "2º Ten"),
	ASPIRANTE_OFICIAL(11,"Aspirante a Oficial","Asp Of"),
	SUB_TENENTE(12,"Subtenente","S Ten"),
    PRIMEIRO_SARGENTO(13,"Primeiro Sargento","1º Sgt"),
    SEGUNDO_SARGENTO(14,"Segundo Sargento","2º Sgt"),
    TERCEIRO_SARGENTO(15,"Terceiro Sargento","3º Sgt"),
    CABO(16,"Cabo","Cb"),
    SOLDADO(17,"Soldado","Sd"),
    TAIFEIRO_MOR(18,"Taifeiro Mor","TMor"),
    TAIFEIRO_PRIMEIRA_CLASSE(19,"Taifeiro de Primeira Classe","T1"),
    TAIFEIRO_SEGUNDA_CLASSE(20,"Taifeiro de Segunda Classe","T2"),
	RECRUTA(21, "Recruta", "Sd");
	
	private int cod;
	private String nome;
	private String nomeAbrv;
	
	Patente(int i, String nome, String nomeAbr){
		this.cod = i;
		this.nomeAbrv = nomeAbr;
		this.nome = nome; 
	}

	public int getCodigo() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeAbr() {
		return nomeAbrv;
	}

}