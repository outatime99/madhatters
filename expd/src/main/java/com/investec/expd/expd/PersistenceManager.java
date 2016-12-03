/**
 * 
 */
package com.investec.expd.expd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author gregf
 *
 *         This persistence manager is just used for J2SE testing of the model.
 *         When running from camel IT IS NOT USED
 * 
 */
public enum PersistenceManager {
	INSTANCE;

	private EntityManagerFactory emFactory;

	private PersistenceManager() {
		emFactory = Persistence.createEntityManagerFactory("primary");
	}

	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public void close() {
		emFactory.close();
	}
}
