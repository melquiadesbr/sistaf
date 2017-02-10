package br.mil.eb.sistaf.resository.filter;

import java.io.Serializable;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Taf;

public class ResultadoFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Militar militar;
	private Taf taf;
	
	public Militar getMilitar() {
		return militar;
	}
	public void setMilitar(Militar militar) {
		this.militar = militar;
	}
	public Taf getTaf() {
		return taf;
	}
	public void setTaf(Taf taf) {
		this.taf = taf;
	}
	
	

}
