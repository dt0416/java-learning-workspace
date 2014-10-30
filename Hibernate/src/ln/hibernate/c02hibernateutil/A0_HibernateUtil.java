package ln.hibernate.c02hibernateutil;

import org.hibernate.Session;

import ln.hibernate.c01hibernatedemo.pojo.Student;


/**
 * 透過HibernateUtil取得Session, 簡化與一致化取得Session
 * 
 * 原則:
 * 1. 在一個執行緒，保證使用同一個Session，使用getCurrentSession()
 * 2. 在一個執行緒，需要使用不同的Session，使用openSession()
 * 
 * 注意:
 * 透過getCurrentSession()取得的Session在commit/rollback後會自動close，但仍建議要手動關閉(需加上保護)
 * 透過openSession()取得的Session必須手動關閉
 * 
 * 使用getCurrentSession()Hibernate規定一定要使用Transaction
 * 使用openSession()則可不一定要使用Transaction
 * 
 * @author Ian Chen
 */
public class A0_HibernateUtil {
	public static void main(String[] args) {
		/**
		 * 創建Session, 透過HibernateUtilBasic
		 */
		Session sessionBasic = HibernateUtilBasic.getSessionFactory().openSession();
		Session sessionBasic2 = HibernateUtilBasic.getSessionFactory().openSession();
		
		/**
		 * 查看是否不同的Session
		 * 結論:不同Session
		 */
		System.out.println(sessionBasic.hashCode());
		System.out.println(sessionBasic2.hashCode());

		/**
		 * getCurrentSession
		 * 方法1:透過HibernateUtil
		 */
		Session session = HibernateUtil.getCurrentSession();
		Session session2 = HibernateUtil.getCurrentSession();
		/**
		 * getCurrentSession
		 * 方法2:透過SessionFactory.getCurrentSession()
		 * 需在hibernate.cfg.xml配置
		 * <property name="current_session_context_class">thread</property>
		 */
//		Session session = HibernateUtilBasic.getSessionFactory().getCurrentSession();
//		Session session2 = HibernateUtilBasic.getSessionFactory().getCurrentSession();
		
		/**
		 * 查看是否不同的Session
		 * 結論:同一個Session
		 */
		System.out.println(session.hashCode());
		System.out.println(session2.hashCode());

		
		Student std = (Student)session.get(Student.class, new Integer(1));
		System.out.println(String.format("%s, %s, %s", std.getId(), std.getName(), std.getEmail()));
		
		HibernateUtil.closeSession();
		HibernateUtil.shutdown();
	}

}
