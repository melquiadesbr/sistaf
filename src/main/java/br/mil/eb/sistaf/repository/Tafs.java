package br.mil.eb.sistaf.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.resository.filter.TafFilter;
import br.mil.eb.sistaf.service.NegocioException;
import br.mil.eb.sistaf.util.jpa.Transactional;

public class Tafs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Taf guardar(Taf taf) {
		
		return manager.merge(taf);
		
	}
	
	@Transactional
	public void remover(Taf taf) throws NegocioException{
		try{
			taf = porId(taf.getId());
			manager.remove(taf);
			manager.flush();//executa tudo que tiver pendente, pois o remove so marcar pra remover (se o taf estiver sendo usaro em outra parte, sera lancada a excecao aqui e nao apenas quando ele excluir apos ser setado para exclusao
		}catch (PersistenceException e){
			throw new NegocioException("Taf não pode ser excluido.");
		}
	}
	
	public Taf porDtTaf(Date dtTaf) {
		try {
			//linguagem JPQL 
			return manager.createQuery("from Taf where dt_taf = :dtTaf.", Taf.class)
				.setParameter("td_taf", dtTaf)
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public List<Taf> filtrados(TafFilter filtro){
		
		
		Session session = manager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Taf.class);
		
		if(StringUtils.isNotBlank(filtro.getId())){
			criteria.add(Restrictions.eq("id", Long.parseLong(filtro.getId())));
		}
		
		if(null != filtro.getDtTaf()){
			criteria.add(Restrictions.eq("dtTaf", filtro.getDtTaf()));
		}
		
		return criteria.addOrder(Order.asc("dtTaf")).list();
		
		//Session session = manager.unwrap(Session.class);		
		//return session.createQuery("from Taf", Taf.class).getResultList();
	}
	
	public Taf porId(Long id){
		return manager.find(Taf.class,  id);
	}
	
	public List<Taf> carregaTafs() {
		return manager.createQuery("from Taf", Taf.class).getResultList();
	}
	
	

}
