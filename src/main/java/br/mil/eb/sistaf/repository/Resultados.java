package br.mil.eb.sistaf.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.resository.filter.MilitarFilter;
import br.mil.eb.sistaf.resository.filter.ResultadoFilter;
import br.mil.eb.sistaf.service.NegocioException;
import br.mil.eb.sistaf.util.jpa.Transactional;

public class Resultados implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Resultado guardar(Resultado resultado) {
		
		return manager.merge(resultado);
		
	}
	
	@Transactional
	public void remover(Resultado resultado) throws NegocioException{
		try{
			resultado = porId(resultado.getId());
			manager.remove(resultado);
			manager.flush();//executa tudo que tiver pendente, pois o remove so marcar pra remover (se o indice estiver sendo usaro em outra parte, sera lancada a excecao aqui e nao apenas quando ele excluir apos ser setado para exclusao
		}catch (PersistenceException e){
			throw new NegocioException("Resultado não pode ser excluido.");
		}
	}
	
	public List<Resultado> filtrados(ResultadoFilter filtro){
		
		Session session = manager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Resultado.class);
		
		/*
		if(StringUtils.isNotBlank(filtro.getIdentidade())){
			criteria.add(Restrictions.eq("identidade", filtro.getIdentidade()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeGuerra())){
			criteria.add(Restrictions.ilike("nomeGuerra", filtro.getNomeGuerra(), MatchMode.ANYWHERE));
		}
		*/
		
		return criteria.addOrder(Order.asc("codBarra")).list();
	}

	public Resultado porId(Long id){
		return manager.find(Resultado.class,  id);
	}
	
	public Resultado porTafUnico(Long idTaf, Long idMilitar){
		//return manager.createQuery("from Resultado where taf_id = :idTaf AND militar_id = :idMilitar", Resultado.class);
		return manager.find(Resultado.class,  idMilitar);
	}
	
	public List<Resultado> carregaResultados() {
		return manager.createQuery("from Resultado", Resultado.class).getResultList();
	}
	

}
