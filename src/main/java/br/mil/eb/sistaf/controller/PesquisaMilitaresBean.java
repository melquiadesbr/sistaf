package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.repository.Militares;
import br.mil.eb.sistaf.resository.filter.MilitarFilter;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class PesquisaMilitaresBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Militares militares;
	
	private MilitarFilter filtro;
	private List<Militar> militaresFiltrados;
	private List<Militar> militaresFiltradosPrimefaces;
	
	private Militar militarSelecionado;
	
	public PesquisaMilitaresBean() {
		filtro = new MilitarFilter();
	}
	
	
	public void excluir() {
		
		try {
			militares.remover(militarSelecionado);//remove do banco
			militaresFiltrados.remove(militarSelecionado);//remove da lista exibida
			
			FacesUtil.addInfoMessage("Militar " + militarSelecionado.getNomeGuerra() + ", idt = " 
					+ militarSelecionado.getIdentidade() 
					+ " excluído com sucesso.");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
		
	}
	
	
	public void pesquisar() {
		militaresFiltrados = militares.filtrados(filtro);
	}
	
	public List<Militar> getMilitaresFiltrados() {
		return militaresFiltrados;
	}

	public MilitarFilter getFiltro() {
		return filtro;
	}

	public Militar getMilitarSelecionado() {
		return militarSelecionado;
	}

	
	public List<Militar> getMilitaresFiltradosPrimefaces() {
		return militaresFiltradosPrimefaces;
	}


	public void setMilitaresFiltradosPrimefaces(List<Militar> militaresFiltradosPrimefaces) {
		this.militaresFiltradosPrimefaces = militaresFiltradosPrimefaces;
	}


	public void setMilitarSelecionado(Militar militarSelecionado) {
		this.militarSelecionado = militarSelecionado;
	}
	
}