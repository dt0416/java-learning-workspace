package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 參數綁定
 * 優點:
 * 1. 可讀性高
 * 2. 效率高
 * 3. 防止sql injection
 * 
 * 有2種方法
 * 1. 使用:xxx, setXxxtype("xxx", Object)
 * 2. 使用?, setXxxtype(index, Object)
 * 
 * @author Ian Chen
 */
public class A09_SetParameter {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** SetParameter 方法1:使用:xxx *****");
			Query query = session.createQuery("from Student where age = :age and name = :name")
					.setInteger("age", 18)
					.setString("name", "Jeremy")
					;
			// 或者用下列方式
			query.setInteger("age", 18);
			query.setString("name", "Jeremy");
			
			List<Student> students = query.list();
			for (Student std : students) {
				System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));
			}
			
			System.out.println("***** SetParameter 方法2:使用?, 從0開始 *****");
			query = session.createQuery("from Student where age = ? and name = ?")
					.setInteger(0, 18)
					.setString(1, "Jeremy");
			students = query.list();
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
