package canchaSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistentErpSystem implements ErpSystem {

	private CancheroSystem cancheroSystem;
	
	private Session session;

	public PersistentErpSystem() {
		Configuration configuration = new Configuration();
	    configuration.configure();

	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	    session = sessionFactory.openSession();
	    
	    cancheroSystem = new CancheroPersistence(this);
			
	}
	
	
	@Override
	public CancheroSystem cancheroSystem() {	
		return cancheroSystem;
	}



	public void beginTransaction() {
		session.beginTransaction();
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public void close() {
		session.close();
	}

	public Session session() {
		return session;
	}


}
