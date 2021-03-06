package br.mil.eb.sistaf.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.mil.eb.sistaf.model.Pretaf;
import br.mil.eb.sistaf.resository.filter.PretafFilter;
import br.mil.eb.sistaf.service.NegocioException;
import br.mil.eb.sistaf.util.jpa.Transactional;

public class Pretafs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Pretaf guardar(Pretaf pretaf) {
		
		return manager.merge(pretaf);
		
	}
	
	@Transactional
	public void remover(Pretaf pretaf) throws NegocioException{
		try{
			pretaf = porId(pretaf.getId());
			manager.remove(pretaf);
			manager.flush();//executa tudo que tiver pendente, pois o remove so marcar pra remover (se o pretaf estiver sendo usaro em outra parte, sera lancada a excecao aqui e nao apenas quando ele excluir apos ser setado para exclusao
		}catch (PersistenceException e){
			throw new NegocioException("Pretaf não pode ser excluido.");
		}
	}
	
	public List<Pretaf> filtrados(PretafFilter filtro){
		
		Session session = manager.unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Pretaf.class);
		
		return criteria.addOrder(Order.asc("id")).list();
	}
	
	public Pretaf porId(Long id){
		return manager.find(Pretaf.class,  id);
	}

	public List<Pretaf> carregaPretafes() {
		return manager.createQuery("from Pretaf", Pretaf.class).getResultList();
	}
	
	

}
