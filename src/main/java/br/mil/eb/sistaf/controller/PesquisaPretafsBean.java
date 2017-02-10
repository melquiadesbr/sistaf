package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Pretaf;
import br.mil.eb.sistaf.repository.Pretafs;
import br.mil.eb.sistaf.resository.filter.PretafFilter;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class PesquisaPretafsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pretafs pretafs;
	
	private PretafFilter filtro;
	private List<Pretaf> pretafsFiltrados;
	
	private Pretaf pretafSelecionado;
	
	public PesquisaPretafsBean() {
		filtro = new PretafFilter();
	}
	
	
	public void excluir() {
		
		try {
			pretafs.remover(pretafSelecionado);//remove do banco
			pretafsFiltrados.remove(pretafSelecionado);//remove da lista exibida
			
			FacesUtil.addInfoMessage("Pretaf " + pretafSelecionado.getId() + " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	public void pesquisar() {
		pretafsFiltrados = pretafs.filtrados(filtro);
	}
	
	public List<Pretaf> getPretafsFiltrados() {
		return pretafsFiltrados;
	}

	public PretafFilter getFiltro() {
		return filtro;
	}

	public Pretaf getPretafSelecionado() {
		return pretafSelecionado;
	}

	public void setPretafSelecionado(Pretaf pretafSelecionado) {
		this.pretafSelecionado = pretafSelecionado;
	}
	
}