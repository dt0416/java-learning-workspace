package ln.hibernate.c04hql;


import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 新增資料
 * 利用Session.save()，不需使用到Query
 * 
 * Query的insert只支援insert into xxx(c1, c2, ...) select c1, c2, ... from ...
 * 不支援insert into xxx(c1, c2, ...) values (v1, v2, ...)
 * 
 * @author Ian Chen
 */
public class A10_Insert {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Insert *****");
			Student student = new Student(5);
			student.setAge(30);
			student.setName("Insert Data");
			
			session.save(student);
			
			// 假如資料有可能存在則可使用saveOrUpdate
			// session.saveOrUpdate(student);
			
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
