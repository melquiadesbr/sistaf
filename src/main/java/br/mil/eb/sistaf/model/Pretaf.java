package br.mil.eb.sistaf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pretaf")
public class Pretaf implements Serializable{

	private static final long serialVersionUID = 2L;
	
	private Long id;
	private Date dtRealizacao;
	private Date dtEntrega;
	private String resultado;
	private String obs;
	private Militar militar;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(nullable = true)
	public Militar getMilitar() {
		return militar;
	}
	public void setMilitar(Militar militar) {
		this.militar = militar;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDtRealizacao() {
		return dtRealizacao;
	}
	public void setDtRealizacao(Date dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}
	public Date getDtEntrega() {
		return dtEntrega;
	}
	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pretaf other = (Pretaf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
