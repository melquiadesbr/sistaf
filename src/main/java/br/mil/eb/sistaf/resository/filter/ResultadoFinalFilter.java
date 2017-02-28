package br.mil.eb.sistaf.resository.filter;

import java.io.Serializable;

import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.validation.IDENTIDADE;

public class ResultadoFinalFilter implements Serializable{
	
	private int numero;
	private int chamada;
	private int ano;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getChamada() {
		return chamada;
	}
	public void setChamada(int chamada) {
		this.chamada = chamada;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
