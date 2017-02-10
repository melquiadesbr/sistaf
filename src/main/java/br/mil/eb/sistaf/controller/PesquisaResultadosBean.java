package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.repository.Resultados;
import br.mil.eb.sistaf.resository.filter.ResultadoFilter;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class PesquisaResultadosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Resultados resultados;
	
	private ResultadoFilter filtro;
	private List<Resultado> resultadoesFiltrados;
	
	private Resultado resultadoSelecionado;
	
	public PesquisaResultadosBean() {
		filtro = new ResultadoFilter();
	}
	
	
	public void excluir() {
		
		try {
			resultados.remover(resultadoSelecionado);//remove do banco
			resultadoesFiltrados.remove(resultadoSelecionado);//remove da lista exibida
			
			FacesUtil.addInfoMessage("Resultado do militar " + resultadoSelecionado.getMilitar().getNomeGuerra() + ", idt = "  
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	public void pesquisar() {
		resultadoesFiltrados = resultados.filtrados(filtro);
	}
	
	public List<Resultado> getResultadosFiltrados() {
		return resultadoesFiltrados;
	}

	public ResultadoFilter getFiltro() {
		return filtro;
	}

	public Resultado getResultadoSelecionado() {
		return resultadoSelecionado;
	}

	public void setResultadoSelecionado(Resultado resultadoSelecionado) {
		this.resultadoSelecionado = resultadoSelecionado;
	}
	
}