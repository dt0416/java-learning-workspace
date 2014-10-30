package ln.hibernate.c04hql;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 更新、刪除
 * Session：
 *  新舊版本皆可使用
 *  必須明確找出物件
 *  
 * Query:
 *  3以上的版本才可使用
 *  會回傳異動/刪除筆數
 *  語法較彈性
 * 
 * @author Ian Chen
 */
public class A10_UpdateDelete {
	public static void main(String[] args) throws Exception {
		updateDemo();
//		deleteDemo();
	}
	
	public static void updateDemo() throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Update Used By Session *****");
			Student student = new Student(5); // ID不存在"會"出錯
			student.setName("Update By Session");
			session.update(student);
			// 假如資料有可能不存在則可使用saveOrUpdate
			// session.saveOrUpdate(student);

			System.out.println("***** Update Used By Query *****");
			Query query = session.createQuery("update Student set name = 'Update By Query' where id = 5");
			int result = query.executeUpdate();
			System.out.println(result);

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
	
	public static void deleteDemo() throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Delete Used By Session *****");
			Student student = new Student(5); // ID不存在"不會"出錯
			session.delete(student);
			
			System.out.println("***** Delete Used By Query *****");
			Query query = session.createQuery("delete Student where id = 5");
			int result = query.executeUpdate();
			System.out.println(result);
			
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
