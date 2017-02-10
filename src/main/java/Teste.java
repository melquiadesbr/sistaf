import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Pretaf;

public class Teste {

	public static void main(String[] args) {
		
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistafPU");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		
		Militar militar = new Militar();
		militar.setIdentidade("12465465");
		militar.setNomeCompleto("1Tiago José Reis Melquiades");
		militar.setNomeGuerra("Melquiades");
		militar.setPatente(1);
		militar.setSexo("m");
		
		Pretaf pretaf = new Pretaf();
		pretaf.setObs("realizado em dia");
		pretaf.setResultado("APTO");
		pretaf.setDtEntrega(new Date());
		pretaf.setMilitar(militar);
		
		militar.getPreTafs().add(pretaf);
		
		manager.persist(militar);
		
		
		/*
		Cliente cliente = new Cliente();
		cliente.setNome("Tiago");
		cliente.setDocumentoReceitaFederal("foi");
		cliente.setEmail("teste@");
		
		Endereco endereco = new Endereco();
		endereco.setCidade("Brasislia");
		endereco.setCep("343");
		endereco.setLogradouro("rua x");
		endereco.setNumero("23");
		endereco.setUf("MG");
		
		cliente.getEnderecos().add(endereco);
		
		manager.persist(cliente);
		*/
		
		try {
			trx.commit();
		} catch (Exception e){
			manager.close();
			factory.close();
		}
		
		manager.close();
		factory.close();
		
		System.out.println("Militar gravado");

	}

}
