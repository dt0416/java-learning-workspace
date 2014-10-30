package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c01hibernatedemo.pojo.Studentcourse;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 利用外來鍵的特性, Hibernate自動會幫我們join table和select table
 * 此範例需參考hibernate組成的sql可看出自動join或自動select table
 * 
 * @author Ian Chen
 */
public class A07_AutoJoinTable {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** AutoJoin & Select *****");
			Query query = session.createQuery("from Studentcourse where student.name = 'Jordan'");
			List<Studentcourse> students = query.list();
			for (Studentcourse stdc : students) {
				System.out.println(String.format("%s, %s", stdc.getStudent().getName(), stdc.getGrade()));
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
