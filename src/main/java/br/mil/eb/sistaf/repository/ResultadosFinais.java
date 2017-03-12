package br.mil.eb.sistaf.repository;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.resository.filter.ResultadoFinalFilter;

public class ResultadosFinais implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public List<Resultado> filtrados(ResultadoFinalFilter filtro){
		
		Session session = manager.unwrap(Session.class);
		
		Taf taf = new Taf();
		if(filtro.getNumero() != 0) taf.setNumero(filtro.getNumero()); 
		if(filtro.getChamada() != 0) taf.setChamada(filtro.getChamada()); 

		Resultado resultado = new Resultado();

		Example exampleResultado = Example.create(resultado)
				.excludeZeroes()
				.excludeProperty("mencao")
				.excludeProperty("suficiencia")
				.excludeProperty("novaSuficiencia")
				.excludeProperty("dtPretafValido")
				.excludeProperty("novaMencao")
				.excludeProperty("resultadoPretaf")
				.excludeProperty("tafAlternativo");
		
		Example exampleTaf = Example.create(taf)
				.excludeZeroes()
				.excludeProperty("dtCadastro");
		
		
		
		Criteria criteria = session.createCriteria(Resultado.class).add(exampleResultado)
				.createCriteria("taf")
				.add(exampleTaf);
		
		if(filtro.getAno() != 0){
			criteria.add(Restrictions.ge("dtTaf", toStartOfYear(filtro.getAno())));
			criteria.add(Restrictions.le("dtTaf", toEndOfYear(filtro.getAno())));
		}
		
		List<Resultado> resultados = criteria.list();
		      
		return resultados;
		
	}
	
	public Date toStartOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_YEAR, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    return calendar.getTime();
	}

	public Date toEndOfYear(int year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.YEAR, year+1);
	    calendar.set(Calendar.DAY_OF_YEAR, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND,-1);
	    return calendar.getTime();
	}
	
	
}
