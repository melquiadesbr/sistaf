package br.mil.eb.sistaf.controller;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.sistaf.jsf.FacesUtil;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.service.CadastroTafService;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class CadastroTafBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroTafService cadastroTafService;
	
	@Produces
	private Taf taf;
	
	public CadastroTafBean(){
		limpar();
		
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar(){
		System.out.println("Inicializando...");
		if (this.taf == null) {
			limpar();
		}
	}

	public void salvar() throws NegocioException{
		
		try {
			this.taf = cadastroTafService.salvar(this.taf);
			FacesUtil.addInfoMessage("Taf salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		} 
		
		limpar();
		
	}
	
	private void limpar(){
		this.taf = new Taf();
	}

	public Taf getTaf() {
		return taf;
	}

	public void setTaf(Taf taf) {
		this.taf = taf;
	}
	
	public boolean isEditando(){
		return this.taf.getId() != null;
	}
	
	


}