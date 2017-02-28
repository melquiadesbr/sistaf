package br.mil.eb.sistaf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Taf")
public class Taf implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int numero;
	private int chamada;
	private Date dtTaf;
	private int dia;
	private List<Resultado> resultados = new ArrayList<>();
	private boolean ativo = true;
	private Date dtCadastro = new Date(System.currentTimeMillis());
	private String otfm;

	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	@NotNull
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getOtfm() {
		return otfm;
	}
	public void setOtfm(String otfm) {
		this.otfm = otfm;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@OneToMany(mappedBy = "taf", cascade = CascadeType.ALL)
	public List<Resultado> getResultados() {
		return resultados;
	}
	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	@NotNull
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@NotNull
	public int getChamada() {
		return chamada;
	}
	public void setChamada(int chamada) {
		this.chamada = chamada;
	}
	@Column(name = "dt_taf")
	@NotNull
	public Date getDtTaf() {
		return dtTaf;
	}
	public void setDtTaf(Date dtTaf) {
		this.dtTaf = dtTaf;
	}
	@Transient
	public int getAnoTaf(){
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(getDtTaf());

		return calendar.get(Calendar.YEAR);
	}
	@NotNull
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
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
		Taf other = (Taf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
