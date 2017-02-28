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
import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Patente;
import br.mil.eb.sistaf.service.CadastroMilitarService;
import br.mil.eb.sistaf.service.NegocioException;

@Named
@ViewScoped
public class CadastroMilitarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroMilitarService cadastroMilitarService;
	
	@Produces
	private Militar militar;
	
	//truque para usar o enum em um selectOneMenu (utilizando atributos do enum)
	private List<Patente> patentes;
	
	public CadastroMilitarBean(){
		limpar();
		patentes = Arrays.asList(Patente.values());
	}
	
	
	/* aqui vc colocar codigos antes do renderizar, ex... preencher um combobox, etc */
	public void inicializar(){
		System.out.println("Inicializando...");
		if (this.militar == null) {
			limpar();
		}
	}

	public void salvar() throws NegocioException{
		
		try {
			this.militar = cadastroMilitarService.salvar(this.militar);
			FacesUtil.addInfoMessage("Militar salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		} 
		
		limpar();
		
	}
	
	private void limpar(){
		this.militar = new Militar();
	}
	
	public List<Patente> getPatentes() {
	    return patentes;
	}

	public Militar getMilitar() {
		return militar;
	}

	public void setMilitar(Militar militar) {
		this.militar = militar;
	}
	
	public boolean isEditando(){
		return this.militar.getId() != null;
	}
	
	


}