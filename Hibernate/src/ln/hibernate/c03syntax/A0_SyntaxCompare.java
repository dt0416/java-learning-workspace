package ln.hibernate.c03syntax;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * HQL & Criteria比較
 * 
 * @author Ian Chen
 */
public class A0_SyntaxCompare {
	public static void main(String[] args) {
		Session session = HibernateUtil.getCurrentSession();
		
		/**
		 * HQL
		 */
		System.out.println("***** HQL *****");
		Query query = session.createQuery("from Student");
		List<Student> students = query.list();
		Iterator<Student> iterator =  students.iterator();
		while(iterator.hasNext()) {
			Student std = iterator.next();
			System.out.println(String.format("%s, %s, %s", std.getId(), std.getName(), std.getEmail()));
		}
		
		/**
		 * Criteria
		 */
		System.out.println("\n***** Criteria *****");
		Criteria cr = session.createCriteria(Student.class);
		cr.add(Restrictions.ne("id", 9));
		iterator = cr.list().iterator();
		while(iterator.hasNext()) {
			Student std = iterator.next();
			System.out.println(String.format("%s, %s, %s", std.getId(), std.getName(), std.getEmail()));
		}
		
		HibernateUtil.closeSession();
		HibernateUtil.shutdown();
	}
}
