package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 使用between、in...
 * 
 * @author Ian Chen
 */
public class A05_WhereRange {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Between *****");
			Query query = session.createQuery("from Student where age between 18 and 19");
			List<Student> students = query.list();
			for (Student std : students) {
				System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));
			}

			System.out.println("\n***** In *****");
			query = session.createQuery("from Student where age in (18,20)");
			List<Student> students2 = query.list();
			for (Student std : students2) {
				System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));
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
