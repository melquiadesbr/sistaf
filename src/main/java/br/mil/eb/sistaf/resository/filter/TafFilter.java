package br.mil.eb.sistaf.resository.filter;

import java.io.Serializable;
import java.util.Date;

public class TafFilter implements Serializable{
	
	private String id;
	private int numero;
	private Date dtTaf;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDtTaf() {
		return dtTaf;
	}

	public void setDtTaf(Date dtTaf) {
		this.dtTaf = dtTaf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
