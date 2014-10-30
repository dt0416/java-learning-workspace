package ln.hibernate.c02hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 取得Session
 * SessionFactory是執行緒安全的（Thread-safe）
 * Session則不是設計為執行緒安全的
 * 使用HibernateUtilBasic只能透過openSession()取得不同的Session(就算同個執行緒每次取得的Session皆會不同個)
 * HibernateUtil.getCurrentSession()在同個執行緒皆取用同個Session, 且跨執行緒時各自取不同Session
 * 
 * @author Ian Chen
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	static{
		try{
			sessionFactory = new Configuration().configure("ln/hibernate/c01hibernatedemo/hibernate.cfg.xml").buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取得和執行緒關聯的Session
	 * @return
	 */
	public static Session getCurrentSession() {
		Session session = threadLocal.get();
		if (session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}

	public static void closeSession(){
		Session session = threadLocal.get();
		if (session != null && session.isOpen()) {
			session.close();
		}
		threadLocal.set(null);
	}
	
	public static void shutdown(){
		sessionFactory.close();
	}
}
