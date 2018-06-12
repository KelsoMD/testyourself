package by.nesterenok.testyourself.dao.database.hbn;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

public final class SessionFactoryManager {
	
	private SessionFactoryManager() {
		
	}
	
	private static SessionFactory sessionFactory;
	
	private static final String configXml = "config/hibernate.cfg.xml";
	
	private static SessionFactory buildSessionFactory() {
		
		Configuration configuration = new Configuration();
		configuration.configure(configXml);
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}
	
	

}
