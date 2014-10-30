package ln.hibernate.c02hibernateutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 取得Session
 * SessionFactory是執行緒安全的（Thread-safe）
 * Session則不是設計為執行緒安全的
 * 使用HibernateUtilBasic只能透過openSession()取得不同的Session(就算同個執行緒每次取得的Session皆會不同個)
 * 假如要同個執行緒皆取用同個Session, 且跨執行緒時各自取不同Session請使用HibernateUtil
 * 
 * @author Ian Chen
 */
public class HibernateUtilBasic {

	private static SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new Configuration().configure("ln/hibernate/c01hibernatedemo/hibernate.cfg.xml").buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得全新的Session
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown(){
		getSessionFactory().close();
	}
}
