package br.mil.eb.sistaf.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.mil.eb.sistaf.util.IndicesTaf;

@Entity
@Table(name = "Resultado")
public class Resultado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int corrida;
	private int barra;
	private int flexao;
	private int abdominal;
	private int mencao = Mencao.INSUFICIENTE.getIndice();
	private int novaMencao = Mencao.INEXISTENTE.getIndice(); //mensao a partir de 2018 para linha não bélica
	private String codBarra;
	
	private Militar militar;
	private Taf taf;
	
	boolean tafAlternativo = false;
	
	
		
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNovaMencao() {
		return novaMencao;
	}
	public void setNovaMencao(int novaMencao) {
		this.novaMencao = novaMencao;
	}
	public boolean isTafAlternativo() {
		return tafAlternativo;
	}
	public void setTafAlternativo(boolean tafAlternativo) {
		this.tafAlternativo = tafAlternativo;
	}
	public int getCorrida() {
		return corrida;
	}
	public void setCorrida(int corrida) {
		this.corrida = corrida;
	}
	public int getBarra() {
		return barra;
	}
	public void setBarra(int barra) {
		this.barra = barra;
	}
	public int getFlexao() {
		return flexao;
	}
	public void setFlexao(int flexao) {
		this.flexao = flexao;
	}
	public int getAbdominal() {
		return abdominal;
	}
	public void setAbdominal(int abdominal) {
		this.abdominal = abdominal;
	}
	public int getMencao() {
		return mencao;
	}
	public void setMencao(int mencao) {
		this.mencao = mencao;
	}
	@Column(name = "cod_barra")
	public String getCodBarra() {
		return codBarra;
	}
	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}
	@ManyToOne
	@JoinColumn(nullable = true)
	public Taf getTaf() {
		return taf;
	}
	public void setTaf(Taf taf) {
		this.taf = taf;
	}
	@ManyToOne
	@JoinColumn(nullable = true)
	public Militar getMilitar() {
		return militar;
	}
	
	public void setMilitar(Militar militar) {
		this.militar = militar;
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
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient
	public String getMencaoAbr(){
		return Mencao.values()[this.getMencao()].getDescricao();
	}
	
	@Transient
	public String getNovaMencaoAbr(){
		return Mencao.values()[this.getNovaMencao()].getDescricao();
	}
	
	@Transient
	public void processaMencao(){
		
		int[] mencoesPorExercicio = new int[4];//corrida, barra, flexao, abdominal
		int[] mencoesPorExercicio2018 = new int[4];
		
		/************* CALCULO MENCAO CORRIDA  **************/
		Map<String,int[]> indicesCorrida = IndicesTaf.getIndicesCorrida();
				 
		if(this.militar.getIdade() >= 18 && this.militar.getIdade() <= 49){
			for(int i=0; i<4; i++){
				if(this.corrida > indicesCorrida.get(""+this.militar.getIdade()+this.militar.getSexo())[i]){
					mencoesPorExercicio[0] = i+1;
				}
			}
		} else if(this.militar.getIdade() >= 50 && this.militar.getIdade() < 65) {
			if(this.corrida > indicesCorrida.get(""+this.militar.getIdade()+this.militar.getSexo())[0]){//acima de 50 so tem 1 indice
				mencoesPorExercicio[0] = Mencao.SUFICIENTE.getIndice();
			}
		} else {
			mencoesPorExercicio[0] = Mencao.SUFICIENTE.getIndice();
		}
		
		//mensao a partir de 2018
		if(!militar.isLinhaBelica()){
			mencoesPorExercicio2018[0] = Mencao.SUFICIENTE.getIndice();
		}
		/**************************************************************/
		
		this.mencao = mencoesPorExercicio[0]; //TODO recebe o menor valor do array de exercicios
		this.novaMencao = mencoesPorExercicio2018[0]; //TODO recebe o menor valor do array de exercicios
	}
	
	
	
	
}
