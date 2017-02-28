package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotBlank;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.repository.Militares;
import br.mil.eb.sistaf.repository.Resultados;
import br.mil.eb.sistaf.repository.Tafs;
import br.mil.eb.sistaf.service.CadastroResultadoService;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class CadastroResultadoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroResultadoService cadastroResultadoService;
	
	@Produces
	private Resultado resultado;
	
	private String padraoDeDesempenho = "PBD";
	
	private Resultado resultadoSelecionado;
	
	@Inject
	private Militares militares;
	private Militar militar;
	
	private String codigoDeBarraParaRegistro;
	private int indiceCorridaParaRegistro;
	
	@Inject
	private Tafs tafs;
	
	@NotBlank
	private Taf taf;

	@Inject
	private Resultados resultados;
	private List<Resultado> resultadoLista;
	private List<Resultado> resultadosFiltradosPrimefaces;
	
	private List<Militar> militaresLista;
	private List<Taf> tafsLista;
	
	public CadastroResultadoBean() throws NegocioException{
		limpar();
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar() throws NegocioException{
		
		militaresLista = militares.carregaMilitares();
		tafsLista = tafs.carregaTafs();
		
		if (this.resultado == null) {
			limpar();
		} 
		
	}
	
	
	public void carregarResultados(){
		if(null != resultado.getTaf()){
			Taf taf = resultado.getTaf();
			resultadoLista = resultados.filtrados(taf);
		} else {
			resultadoLista = null;
		}
	}

	public void salvar() throws NegocioException{
		
		//verifica se ja nao tem esse codigo de barra sendo usado neste taf
		try {
			
			if(resultado.getTaf() == null){
				throw new NegocioException("Selecione um TAF!");
			}
			
			if(resultado.getMilitar() == null){
				throw new NegocioException("Selecione um Militar!");
			}
			
			for(Resultado resultado : resultadoLista){
				if(this.resultado.getCodBarra() != null && !this.resultado.getCodBarra().equals("") && this.resultado.getCodBarra().equals(resultado.getCodBarra())){
					throw new NegocioException("Código de barra já cadastrado para este TAF");
				}
			}
			if(0 != resultado.getMilitar().getPreTafs().size()){
				this.resultado.setDtPretafValido(resultado.getMilitar().getPreTafs().get(resultado.getMilitar().getPreTafs().size()-1).getDtRealizacao());
				this.resultado.setResultadoPretaf(resultado.getMilitar().getPreTafs().get(resultado.getMilitar().getPreTafs().size()-1).getResultado());
			}
			this.resultado = cadastroResultadoService.salvar(this.resultado);
			carregarResultados();
			FacesUtil.addInfoMessage(resultado.getMilitar().getPatenteAbr() + " " + resultado.getMilitar().getNomeGuerra() + " inserido em TAF com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		} 
		
		limpar();
		
	}
	
	public void salvarLista() throws NegocioException{
		
		
		try {
			for(Resultado resultado : resultadoLista){
				
				//Resultado resultadoAux = resultados.porId(resultado.getId());
				if(0 != resultado.getMilitar().getPreTafs().size()){
					resultado.setDtPretafValido(resultado.getMilitar().getPreTafs().get(resultado.getMilitar().getPreTafs().size()-1).getDtRealizacao());
					resultado.setResultadoPretaf(resultado.getMilitar().getPreTafs().get(resultado.getMilitar().getPreTafs().size()-1).getResultado());
				}
				
				/*** salva o codigo de barra ***/
				if(codigoDeBarraParaRegistro != null && !codigoDeBarraParaRegistro.equals("") && this.codigoDeBarraParaRegistro.equals(resultado.getCodBarra())){
					resultado.setCorrida(indiceCorridaParaRegistro);
					codigoDeBarraParaRegistro = "";
				}
				
				resultado.processaMencao();
				cadastroResultadoService.salvar(resultado);
				
			
			}
			if(!codigoDeBarraParaRegistro.equals("")){//codigo de barra inexistente para este taf
				codigoDeBarraParaRegistro = "";
				throw new NegocioException("Código de barra inexistente para este TAF");
			}
			FacesUtil.addInfoMessage("Lancamento de resultado efetuado com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}

		
	}
	
	public void excluir() {
		
		try {
			resultados.remover(resultadoSelecionado);//remove do banco
			resultadoLista.remove(resultadoSelecionado);//remove da lista exibida
			
			FacesUtil.addInfoMessage("Militar " + resultadoSelecionado.getMilitar().getNomeGuerra() + " excluido do TAF com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}

	private void limpar(){
		this.resultado = new Resultado();
	}

	
	public List<Resultado> getResultadoLista() {
		return resultadoLista;
	}


	public void setResultadoLista(List<Resultado> resultadoLista) {
		this.resultadoLista = resultadoLista;
	}


	public Resultado getResultado() {
		return resultado;
	}

	public List<Resultado> getResultadosFiltradosPrimefaces() {
		return resultadosFiltradosPrimefaces;
	}


	public void setResultadosFiltradosPrimefaces(List<Resultado> resultadosFiltradosPrimefaces) {
		this.resultadosFiltradosPrimefaces = resultadosFiltradosPrimefaces;
	}


	public String getPadraoDeDesempenho() {
		return padraoDeDesempenho;
	}


	public void setPadraoDeDesempenho(String padraoDeDesempenho) {
		this.padraoDeDesempenho = padraoDeDesempenho;
	}


	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	public String getCodigoDeBarraParaRegistro() {
		return codigoDeBarraParaRegistro;
	}


	public void setCodigoDeBarraParaRegistro(String codigoDeBarraParaRegistro) {
		this.codigoDeBarraParaRegistro = codigoDeBarraParaRegistro;
	}


	public int getIndiceCorridaParaRegistro() {
		return indiceCorridaParaRegistro;
	}


	public void setIndiceCorridaParaRegistro(int indiceCorridaParaRegistro) {
		this.indiceCorridaParaRegistro = indiceCorridaParaRegistro;
	}


	public boolean isEditando(){
		return this.resultado.getId() != null;
	}


	public Militares getMilitares() {
		return militares;
	}


	public void setMilitares(Militares militares) {
		this.militares = militares;
	}


	public List<Militar> getMilitaresLista() {
		return militaresLista;
	}


	public void setMilitaresLista(List<Militar> militaresLista) {
		this.militaresLista = militaresLista;
	}


	public Militar getMilitar() {
		return militar;
	}


	public void setMilitar(Militar militar) {
		this.militar = militar;
	}


	public Tafs getTafs() {
		return tafs;
	}


	public void setTafs(Tafs tafs) {
		this.tafs = tafs;
	}


	public Taf getTaf() {
		return taf;
	}


	public void setTaf(Taf taf) {
		this.taf = taf;
	}


	public List<Taf> getTafsLista() {
		return tafsLista;
	}


	public void setTafsLista(List<Taf> tafsLista) {
		this.tafsLista = tafsLista;
	}


	public Resultados getResutlados() {
		return resultados;
	}


	public void setResutlados(Resultados resutlados) {
		this.resultados = resutlados;
	}


	public Resultado getResultadoSelecionado() {
		return resultadoSelecionado;
	}


	public void setResultadoSelecionado(Resultado resultadoSelecionado) {
		this.resultadoSelecionado = resultadoSelecionado;
	}

	


}