package br.mil.eb.sistaf.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Pretaf;
import br.mil.eb.sistaf.repository.Militares;
import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Patente;
import br.mil.eb.sistaf.service.CadastroPretafService;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class CadastroPretafBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroPretafService cadastroPretafService;
	
	@Produces
	private Pretaf pretaf;
	
	@Inject
	private Militares militares;
	private Militar militar;
	
	private List<Militar> militaresLista;
	
	public CadastroPretafBean(){
		limpar();
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar(){
		System.out.println("Inicializando...");
		
		militaresLista = militares.carregaMilitares();
		if (this.pretaf == null) {
			limpar();
		}
	}

	public void salvar() throws NegocioException{
		
		try {
			this.pretaf = cadastroPretafService.salvar(this.pretaf);
			FacesUtil.addInfoMessage("Pretaf salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		} 
		
		limpar();
		
	}
	
	private void limpar(){
		this.pretaf = new Pretaf();
	}

	public Pretaf getPretaf() {
		return pretaf;
	}

	public void setPretaf(Pretaf pretaf) {
		this.pretaf = pretaf;
	}
	
	public boolean isEditando(){
		return this.pretaf.getId() != null;
	}


	public Militares getMilitares() {
		return militares;
	}


	public void setMilitares(Militares militares) {
		this.militares = militares;
	}


	public Militar getMilitar() {
		return militar;
	}


	public void setMilitar(Militar militar) {
		this.militar = militar;
	}


	public List<Militar> getMilitaresLista() {
		return militaresLista;
	}


	public void setMilitaresLista(List<Militar> militaresLista) {
		this.militaresLista = militaresLista;
	}
	
	


}