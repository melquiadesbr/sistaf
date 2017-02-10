package br.mil.eb.sistaf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.sistaf.util.jpa.Transactional;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.repository.Militares;
import br.mil.eb.sistaf.repository.Tafs;

public class CadastroTafService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tafs tafs;
	
	@Transactional
	public Taf salvar(Taf taf) throws NegocioException{
		
		return tafs.guardar(taf);
		
	}

}
