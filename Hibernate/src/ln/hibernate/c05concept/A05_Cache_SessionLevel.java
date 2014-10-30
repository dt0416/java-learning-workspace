package ln.hibernate.c05concept;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 一級快取(Session Level)
 * 只有透過get、load才會從cache裡取得
 * 注意：list、uniqueResult皆會建立(儲存)cache，但不會從cache裡取得資料
 * 
 * @author Ian Chen
 */
public class A05_Cache_SessionLevel {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			System.out.println("***** HQL, 使用list存放cache *****");
			Query query = session.createQuery("from Student where id=1");
			Student student = (Student) query.list().get(0);
//			Student student = (Student) query.uniqueResult(); // uniqueResult也會存放cache 
//			Student student = (Student) session.load(Student.class, 1); // get也會存放cache
			System.out.println(String.format("%s, %s, %s, %s", student.getId(), student.getName(), student.getEmail(), student.getAge()));
			
			System.out.println("***** 透過cache取得同一個學生-load *****");
			Student student2 = (Student) session.load(Student.class, 1);
			System.out.println(String.format("%s, %s, %s, %s", student2.getId(), student2.getName(), student2.getEmail(), student2.getAge()));

			System.out.println("***** 透過cache取得同一個學生-get *****");
			Student student3 = (Student) session.get(Student.class, 1);
			System.out.println(String.format("%s, %s, %s, %s", student3.getId(), student3.getName(), student3.getEmail(), student3.getAge()));

			System.out.println("***** evict後透過cache取得同一個學生-load，快取不見了，所以需再向DB取得一次資料 *****");
			session.evict(student);
//			session.clear(); // clear可以清掉所有cache
			Student student4 = (Student) session.load(Student.class, 1);
			System.out.println(String.format("%s, %s, %s, %s", student4.getId(), student4.getName(), student4.getEmail(), student4.getAge()));

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
