package ln.hibernate.c04hql;

import java.util.List;

import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 使用group By、having、聚合函式:avg、sum、min、max、count
 * 無法使用映射物件
 * 
 * @author Ian Chen
 */
public class A06_GroupBy {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Group By *****");
			Query query = session.createQuery("select age, avg(age) from Student group by age");
			List<Object[]> students = query.list();
			for (Object[] emp : students) {
				System.out.println(String.format("%s, %s", emp[0], emp[1]));
			}

			System.out.println("\n***** Having *****");
			query = session.createQuery("select age, avg(age) from Student group by age having avg(age) > 18.5");
			students = query.list();
			for (Object[] emp : students) {
				System.out.println(String.format("%s, %s", emp[0], emp[1]));
			}

			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			HibernateUtil.closeSession();
			HibernateUtil.shutdown();
		}
	}
}
