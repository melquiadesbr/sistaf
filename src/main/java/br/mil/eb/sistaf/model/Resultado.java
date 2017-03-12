package br.mil.eb.sistaf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	private int mencao = Mencao.INEXISTENTE.getIndice();
	private int novaMencao = Mencao.INEXISTENTE.getIndice(); //mensao a partir de 2018
	private String codBarra;
	
	private Militar militar;
	private Taf taf;
	
	boolean tafAlternativo = false;
	private String suficiencia = "-";
	private String novaSuficiencia = "-"; //suficiencia a apartir de 2018
	
	private Date dtPretafValido;
	private String resultadoPretaf = "Não Realizado";
	
	private String padraoDesempenho;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "nova_suficiencia")
	public String getNovaSuficiencia() {
		return novaSuficiencia;
	}
	public void setNovaSuficiencia(String novaSuficiencia) {
		this.novaSuficiencia = novaSuficiencia;
	}
	@Column(name = "padrao_desempenho")
	public String getPadraoDesempenho() {
		return padraoDesempenho;
	}
	public void setPadraoDesempenho(String padraoDesempenho) {
		this.padraoDesempenho = padraoDesempenho;
	}
	@Column(name = "nova_mencao")
	public int getNovaMencao() {
		return novaMencao;
	}
	public void setNovaMencao(int novaMencao) {
		this.novaMencao = novaMencao;
	}
	
	public String getSuficiencia() {
		return suficiencia;
	}
	public void setSuficiencia(String suficiencia) {
		this.suficiencia = suficiencia;
	}
	@Column(name = "taf_alternativo")
	public boolean isTafAlternativo() {
		return tafAlternativo;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_pretaf_valido")
	public Date getDtPretafValido() {
		return dtPretafValido;
	}
	public void setDtPretafValido(Date dtPretafValido) {
		this.dtPretafValido = dtPretafValido;
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
	@Column(name = "resultado_pretaf")
	public String getResultadoPretaf() {
		return resultadoPretaf;
	}
	public void setResultadoPretaf(String resultadoPretaf) {
		this.resultadoPretaf = resultadoPretaf;
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
	@JoinColumn(nullable = false)
	public Taf getTaf() {
		return taf;
	}
	public void setTaf(Taf taf) {
		this.taf = taf;
	}
	@ManyToOne
	@JoinColumn(nullable = false)
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
	public String getResumoTaf(){
		
		return "" + this.getTaf().getNumero() + "º / " 
				+ this.getTaf().getChamada() + "ª Ch. / " 
				+ this.getTaf().getAnoTaf();
		
	}

	@Transient
	public void processaMencao(){
		
		String[] siglaExercicio = {"B", "C", "F", "A"};
		int[] indicesDoMilitar = {this.barra, this.corrida, this.flexao, this.abdominal};
		
		if(indicesDoMilitar[0]==0 && indicesDoMilitar[1]==0 && indicesDoMilitar[2]==0 && indicesDoMilitar[3]==0){
			this.mencao = Mencao.INEXISTENTE.getIndice();
			this.suficiencia = "-";
			return;
		} else {
			this.mencao = Mencao.INSUFICIENTE.getIndice();//inicia com a ultima mencao
		}
		
		int[] mencoesPorExercicio = new int[4];//corrida, barra, flexao, abdominal
		int[] mencoesPorExercicio2018 = new int[4];
		
		boolean primeiraVezNoIf = true;
		
		/************* CALCULO MENCAO  **************/
		Map<String,int[]> indicesTaf = IndicesTaf.getIndices();
			
		for(int x = 0; x < 4; x++){
			
			if(this.militar.getSexo().equals("F") && primeiraVezNoIf){
				mencoesPorExercicio[0] = 5;
				x++;//se for mulher nao faz barra
				primeiraVezNoIf = false;
			} 
			
			if(this.militar.getIdade() >= 18 && this.militar.getIdade() <= 49){
				for(int i=0; i<4; i++){
					if(indicesDoMilitar[x] > indicesTaf.get(""+siglaExercicio[x]+this.militar.getIdade()+this.militar.getSexo())[i]){
						mencoesPorExercicio[x] = i+1;
					}
				}
			} else if(this.militar.getIdade() >= 50 && this.militar.getIdade() < 65) {
				if(indicesDoMilitar[x] > indicesTaf.get(""+siglaExercicio[x]+this.militar.getIdade()+this.militar.getSexo())[0]){//acima de 50 so tem 1 indice
					mencoesPorExercicio[x] = Mencao.SUFICIENTE.getIndice();
				}
			} else {
				mencoesPorExercicio[x] = Mencao.SUFICIENTE.getIndice();
			}
			
			//se for taf alternativo, colocar mencao R para indices que nao foram feitos
			if(indicesDoMilitar[x] == 0 && this.tafAlternativo){
				mencoesPorExercicio[x] = (this.padraoDesempenho.equals("PBD") ? Mencao.REGULAR.getIndice() : Mencao.BOM.getIndice());
			}
			
			//mensao a partir de 2018
			if(!militar.isLinhaBelica()){
				mencoesPorExercicio2018[x] = Mencao.INEXISTENTE.getIndice();
			} else {
				mencoesPorExercicio2018[x] = mencoesPorExercicio[x];
			}
			
		}
			
		/**************************************************************/
		
		this.mencao = retornarMenor(mencoesPorExercicio); 
		this.novaMencao = retornarMenor(mencoesPorExercicio);
		
		//verifica se foi taf alternativo
		if(this.tafAlternativo && this.mencao > Mencao.BOM.getIndice()){
			this.mencao = (this.padraoDesempenho.equals("PBD") ? Mencao.REGULAR.getIndice() : Mencao.BOM.getIndice());
		}
		
		processaSuficiencia();
		
		
	}
	
	private void processaSuficiencia(){
		
		if(this.mencao >= Mencao.BOM.getIndice() && this.padraoDesempenho.equals("PAD")){
			this.suficiencia = "S";
		} else if (this.mencao >= Mencao.REGULAR.getIndice() && this.padraoDesempenho.equals("PBD")){
			this.suficiencia = "S";
		} else {
			this.suficiencia = "NS";
		}
		
	}
	
	private int retornarMenor(int[] array){
		int menorValor = array[0];
		for(int i=0; i<4; i++){
			if(array[i] < menorValor){
				menorValor = array[i];
			}
		}
		return menorValor;
	}
	
	
	
	
}
