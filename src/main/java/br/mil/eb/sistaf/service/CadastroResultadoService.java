package br.mil.eb.sistaf.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.mil.eb.sistaf.util.jpa.Transactional;
import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.repository.Resultados;

public class CadastroResultadoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Resultados resultados;
	
	@Transactional
	public Resultado salvar(Resultado resultado) throws NegocioException{

		/*
		if(resultado != null){
			Resultado resultadoExistente = resultados.porTafUnico(resultado.getTaf().getId(), resultado.getMilitar().getId());
			
			if (resultadoExistente != null && !resultadoExistente.equals(resultado)) {
				throw new NegocioException("Este militar, já esta cadastrado neste TAF.");
			}
		}
		*/
		
		return resultados.guardar(resultado);
			
	}

}
