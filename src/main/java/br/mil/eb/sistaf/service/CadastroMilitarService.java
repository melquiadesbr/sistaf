package br.mil.eb.sistaf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.sistaf.util.jpa.Transactional;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.repository.Militares;

public class CadastroMilitarService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Militares militares;
	
	@Transactional
	public Militar salvar(Militar militar) throws NegocioException{

			Militar militarExistente = militares.porIdentidade(militar.getIdentidade());
			
			if (militarExistente != null && !militarExistente.equals(militar)) {
				throw new NegocioException("Já existe um militar com a identidade informada.");
			}
			
			return militares.guardar(militar);
			
			
	
	}

}
