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
import br.mil.eb.sistaf.resository.filter.MilitarFilter;
import br.mil.eb.sistaf.service.NegocioException;
import br.mil.eb.sistaf.util.jpa.Transactional;

public class Militares implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Militar guardar(Militar militar) {
		
		return manager.merge(militar);
		
	}
	
	@Transactional
	public void remover(Militar militar) throws NegocioException{
		try{
			militar = porId(militar.getId());
			manager.remove(militar);
			manager.flush();//executa tudo que tiver pendente, pois o remove so marcar pra remover (se o militar estiver sendo usaro em outra parte, sera lancada a excecao aqui e nao apenas quando ele excluir apos ser setado para exclusao
		}catch (PersistenceException e){
			throw new NegocioException("Militar não pode ser excluido.");
		}
	}
	
	public Militar porIdentidade(String identidade) {
		try {
			//linguagem JPQL 
			return manager.createQuery("from Militar where identidade = :identidade", Militar.class)
				.setParameter("identidade", identidade)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public List<Militar> filtrados(MilitarFilter filtro){
		
		Session session = manager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Militar.class);
		
		if(StringUtils.isNotBlank(filtro.getIdentidade())){
			criteria.add(Restrictions.eq("identidade", filtro.getIdentidade()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNomeGuerra())){
			criteria.add(Restrictions.ilike("nomeGuerra", filtro.getNomeGuerra(), MatchMode.ANYWHERE));
		}
		
		return criteria.addOrder(Order.asc("nomeGuerra")).list();
	}
	
	public Militar porId(Long id){
		return manager.find(Militar.class,  id);
	}

	public List<Militar> carregaMilitares() {
		return manager.createQuery("from Militar", Militar.class).getResultList();
	}
	
	

}
