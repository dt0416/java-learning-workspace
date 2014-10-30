package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 單一資料列直接返回一個POJO物件
 * 當有多列會有NonUniqueResultException
 * 當無資料返回Null
 * 
 * @author Ian Chen
 */
public class A03_SingleResult {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** HQL *****");
			Query query = session.createQuery("from Student where id = 1");
			Student std = (Student)query.uniqueResult();
			System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));

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
