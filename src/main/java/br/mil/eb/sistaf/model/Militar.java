package br.mil.eb.sistaf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.enterprise.inject.Produces;
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
@Table(name = "Militar")
public class Militar implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String identidade;
	private String nomeCompleto;
	private String nomeGuerra;
	private Date dtNascimento;
	private int patente;
	private String sexo;
	private String email;
	private List<Pretaf> preTafs = new ArrayList<>();
	private List<Resultado> resultados = new ArrayList<>();
	private boolean linhaBelica = false;
	private String quadro;
	private boolean ativo = true;
	private Date dtCadastro = new Date(System.currentTimeMillis());
	private String om;

	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "linha_belica")
	public boolean isLinhaBelica() {
		return linhaBelica;
	}
	public void setLinhaBelica(boolean linhaBelica) {
		this.linhaBelica = linhaBelica;
	}
	@OneToMany(mappedBy = "militar", cascade = CascadeType.ALL)
	public List<Resultado> getResultados() {
		return resultados;
	}
	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	@OneToMany(mappedBy = "militar", cascade = CascadeType.ALL)
	public List<Pretaf> getPreTafs() {
		return preTafs;
	}
	public void setPreTafs(List<Pretaf> preTafs) {
		this.preTafs = preTafs;
	}
	
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	@Column(name = "nome_completo")
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	@Column(name = "nome_guerra")
	@NotNull
	@NotBlank
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	@NotNull
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	@NotNull
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getPatente() {
		return patente;
	}
	public void setPatente(int patente) {
		this.patente = patente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Transient
	public String getPatenteAbr(){
		return Patente.values()[this.getPatente()].getNomeAbr();
	}
	public String getQuadro() {
		return quadro;
	}
	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_cadastro")
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public String getOm() {
		return om;
	}
	public void setOm(String om) {
		this.om = om;
	}
	
	@Transient
	public String getUltimoPretaf() {
		if(preTafs.isEmpty()){
			return "Não Realizado";
		} else {
			return preTafs.get(preTafs.size()-1).getResultado() + " / " + preTafs.get(preTafs.size()-1).getAnoPretaf();
		}
	}
	
	@Transient
	public int getIdade() {
		
		if(this.dtNascimento!=null){
		
	        Calendar dateOfBirth = new GregorianCalendar();
	
	        dateOfBirth.setTime(this.dtNascimento);
	
	        // Cria um objeto calendar com a data atual
	        Calendar today = Calendar.getInstance();
	
	        // Obtém a idade baseado no ano
	        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
	
	        dateOfBirth.add(Calendar.YEAR, age);
	
	        // se a data de hoje é antes da data de Nascimento, então diminui 1.
	        if (today.before(dateOfBirth)) {
	
	            age--;
	
	        }

        return age;
        
		} else {
			return 0;
		}

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
		Militar other = (Militar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
