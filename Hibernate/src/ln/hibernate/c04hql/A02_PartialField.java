package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 查詢部分欄位
 * 優點:佔用較少記憶體
 * 缺點:無法使用映射物件, 發揮Hibernate功能
 * 
 * @author Ian Chen
 */
public class A02_PartialField {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			
			/**
			 * 查詢全部欄位映射POJO物件
			 */
			System.out.println("***** 所有欄位 *****");
			Query query = session.createQuery("from Student");
			List<Student> students = query.list();
			for (Student std : students) {
				System.out.println(String.format("%s, %s, %s", std.getId(), std.getName(), std.getEmail()));
			}
			
			/**
			 * 只查詢部分欄位, 無法映射POJO物件
			 */
			System.out.println("\n***** 部分欄位 *****");
			query = session.createQuery("select id, name from Student");
			List partialStudents = query.list();
			for (Object std : partialStudents) {
				Object[] stdO = (Object[])std;
				System.out.println(String.format("%s, %s", stdO[0], stdO[1]));
			}

			System.out.println("\n***** 部分欄位2 *****");
			query = session.createQuery("select id, name from Student");
			List<Object[]> partialStudents2 = query.list();
			for (Object[] std : partialStudents2) {
				System.out.println(String.format("%s, %s", std[0], std[1]));
			}

			System.out.println("\n***** 部分欄位3, 單一欄位不可用Object[] *****");
			query = session.createQuery("select name from Student");
			List<Object> partialStudents3 = query.list();
			for (Object std : partialStudents3) {
				System.out.println(String.format("%s", std));
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
