package ln.hibernate.c01hibernatedemo;

import ln.hibernate.c01hibernatedemo.pojo.Student;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * 步驟(假設已建置好DB):
 * 1. hibernate.cfg.xml
 *    參考:http://docs.jboss.org/hibernate/core/3.5/reference/en-US/html/session-configuration.html
 * 2. POJO Class(Persistent Classes) with *.hbm.xml(Basic O/R Mapping)
 *    POJO參考:http://docs.jboss.org/hibernate/core/3.5/reference/en-US/html/persistent-classes.html
 *    參考:http://docs.jboss.org/hibernate/core/3.5/reference/en-US/html/mapping.html
 * 3. 將*.hbm.xml設定至hibernate.cfg.xml
 *    <mapping resource="pkg/Xxx.hbm.xml" />

 * @author Ian Chen
 */
public class A0_FirstHibernate {
	public static void main(String[] args) {
		/**
		 * 取得Configuration
		 */
		// 預設抓:/hibernate.cfg.xml
		// Configuration configuragion = new Configuration().configure();
		// 假如cfg檔不在此路徑則使用如下
		// Configuration configuragion = new Configuration().configure("pkg/xxx.xml");
		Configuration configuragion = new Configuration().configure("ln/hibernate/c01hibernatedemo/hibernate.cfg.xml");

		/**
		 * 創建SessionFactory
		 * 對應一個DB最好只有一個SessionFactory, 否則會佔用過多記憶體
		 */
		SessionFactory sessionFactory = configuragion.buildSessionFactory();
		
		/**
		 * 創建Session, 透過SessionFactory
		 * 可以想像成Connection
		 */
		Session session = sessionFactory.openSession();
		/**
		 * 使用當前的Session(一致的Session)
		 * 需在cfg.xml設定屬性hibernate.current_session_context_class, 通常值會設定thread
		 * jta則是可以跨DB, Session範圍更大
		 * 且一定要使用Transaction, commit後會自動close(手動close會有Exception)
		 */
		// Session session = sessionFactory.getCurrentSession();
		
		/**
		 * get vs load 
		 * 以id取得POJO物件
		 * get: 先到二級快取去取
		 *      取不到會即時去取
		 *      取不到會return null
		 * load:先到二級快取去取
		 *      取不到會返回一個代理對象, 等到需要用時才取(lazy)(透過lazy屬性可以設定成false)
		 *      取不到會有Exception(ObjectNotFoundException)
		 */
		Student std = (Student)session.get(Student.class, new Integer(1));
		System.out.println(String.format("%s, %s, %s", std.getId(), std.getName(), std.getEmail()));
		
		/**
		 * Close
		 */
		session.close();
		sessionFactory.close();
	}

}
