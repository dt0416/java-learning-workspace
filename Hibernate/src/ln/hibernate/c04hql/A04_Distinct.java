package ln.hibernate.c04hql;

import java.util.List;

import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 使用distinct
 * 無法使用映射物件
 * 
 * @author Ian Chen
 */
public class A04_Distinct {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Distinct *****");
			Query query = session.createQuery("select distinct name, age from Student");
			List<Object[]> employees = query.list();
			for (Object[] emp : employees) {
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
