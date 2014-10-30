package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 外部SQL
 * 1. 先在hibernate.cfg.xml裡設定<!-- Mapping Syntax -->
 * 2. 在Mapping Syntax的檔案裡新增<query name="ln.hibernate.AllStudent">...</query>
 * 
 * @author Ian Chen
 */
public class A11_OutSyntax {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** HQL *****");
//			Query query = session.createQuery("from Student");
			Query query = session.getNamedQuery("ln.hibernate.AllStudent");
			List<Student> students = query.list();
			for (Student std : students) {
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
