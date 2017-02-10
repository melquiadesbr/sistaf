package br.mil.eb.sistaf.resository.filter;

import java.io.Serializable;

import br.mil.eb.sistaf.validation.IDENTIDADE;

public class MilitarFilter implements Serializable{
	
	private String identidade;
	private String nomeGuerra;
	
	//@IDENTIDADE --> formato especifico
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	
	

}
