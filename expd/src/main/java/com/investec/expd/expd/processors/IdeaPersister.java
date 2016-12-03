/**
 * 
 */
package com.investec.expd.expd.processors;

import javax.persistence.EntityManager;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

import com.investec.expd.expd.PersistenceManager;
import com.investec.expd.expd.model.Idea;

/**
 * @author gregf (stolen from Luigi, just converted for log4j)
 * 
 * TODO: Rather move this into a centralised utils project
 *
 */
public class IdeaPersister implements Processor  {
	
	final static Logger logger = Logger.getLogger(IdeaPersister.class);

	public void process(Exchange exchange) throws Exception {

		logger.info("Persisting the idea");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Idea idea = exchange.getIn().getBody(Idea.class);
		em.persist(idea);
		em.getTransaction().commit();
        em.close();
        
		/*
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		Message msg = exchange.getIn();
		em.getTransaction().begin();
		
		Idea idea = new Idea();
		idea.setIdeaName("Some Name");
		idea.setIdeaDescription("Some Description");
		
		em.persist(idea);
		
		em.getTransaction().commit();
        em.close();
		
		msg.setBody(idea);
		exchange.setOut(msg);	
		*/		
	}
}
