package br.mil.eb.sistaf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Pretaf;
import br.mil.eb.sistaf.repository.Pretafs;
import br.mil.eb.sistaf.util.jpa.Transactional;

public class CadastroPretafService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pretafs pretafs;
	
	@Transactional
	public Pretaf salvar(Pretaf pretaf) throws NegocioException{

			return pretafs.guardar(pretaf);
			
			
	
	}

}
