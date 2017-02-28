package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.repository.ResultadosFinais;
import br.mil.eb.sistaf.resository.filter.ResultadoFinalFilter;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class ResultadoFinalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Produces
	private Resultado resultado;

	@Inject
	private ResultadosFinais resultados;
	private List<Resultado> resultadosFiltrados;
	private List<Resultado> resultadosFiltradosPrimefaces;
	
	private ResultadoFinalFilter filtro;
	
	public ResultadoFinalBean() throws NegocioException{
		filtro = new ResultadoFinalFilter();
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar() throws NegocioException{
		
		//carrega resultado do ultimo TAF para exibir primeiro
		//resultadoLista = resultados.carregaResultados();
		
		if (this.resultado == null) {
			limpar();
		} 
		
	}
	
	public void buscar(){
		resultadosFiltrados = resultados.filtrados(filtro);
	}
	
	private void limpar(){
		this.resultado = new Resultado();
	}


	public Resultado getResultado() {
		return resultado;
	}


	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}


	public ResultadosFinais getResultados() {
		return resultados;
	}


	public void setResultados(ResultadosFinais resultados) {
		this.resultados = resultados;
	}


	public List<Resultado> getResultadosFiltrados() {
		return resultadosFiltrados;
	}


	public void setResultadosFiltrados(List<Resultado> resultadoLista) {
		this.resultadosFiltrados = resultadoLista;
	}


	public List<Resultado> getResultadosFiltradosPrimefaces() {
		return resultadosFiltradosPrimefaces;
	}


	public void setResultadosFiltradosPrimefaces(List<Resultado> resutladosFiltradosPrimefaces) {
		this.resultadosFiltradosPrimefaces = resutladosFiltradosPrimefaces;
	}

	public ResultadoFinalFilter getFiltro() {
		return filtro;
	}


	public void setFiltro(ResultadoFinalFilter filtro) {
		this.filtro = filtro;
	}
	
	

	
	


}