package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.repository.Tafs;
import br.mil.eb.sistaf.resository.filter.TafFilter;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class PesquisaTafsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tafs tafs;
	
	private TafFilter filtro;
	private List<Taf> tafsFiltrados;
	
	private Taf tafSelecionado;
	
	public PesquisaTafsBean() {
		filtro = new TafFilter();
	}
	
	
	public void excluir() {
		
		try {
			tafs.remover(tafSelecionado);//remove do banco
			tafsFiltrados.remove(tafSelecionado);//remove da lista exibida
			
			FacesUtil.addInfoMessage("Taf " + tafSelecionado.getNumero() + ", data = " 
					+ tafSelecionado.getDtTaf() 
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	public void pesquisar() {
		tafsFiltrados = tafs.filtrados(filtro);
	}
	
	public List<Taf> getTafsFiltrados() {
		return tafsFiltrados;
	}

	public TafFilter getFiltro() {
		return filtro;
	}

	public Taf getTafSelecionado() {
		return tafSelecionado;
	}

	public void setTafSelecionado(Taf tafSelecionado) {
		this.tafSelecionado = tafSelecionado;
	}
	
}