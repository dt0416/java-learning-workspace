package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * 分頁SQL
 * setFirstResult(int) -> base=0, 從第幾筆開始取
 * setMaxResults(int) -> 取得幾筆(等同pageSize), 最後一頁筆數不夠不會出錯
 * 
 * pageCount好用公式
 * pageCount = (rowCount-1)/pageSize + 1
 * 
 * @author Ian Chen
 */
public class A08_PagingResult {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** PagingSql *****");
			// 從第0筆取3筆
			Query query = session.createQuery("from Student order by age").setFirstResult(0)
					.setMaxResults(3);
			List<Student> students = query.list();
			for (Student std : students) {
				System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));
			}
			
			System.out.println("\n***** PagingSql All Result *****");
			// 用分頁列出全部結果
			int pageSize = 3;
			int rowCount = Integer.parseInt(session.createQuery("select count(*) from Student").uniqueResult().toString());
			// int rowCount = ((Long)session.createQuery("select count(*) from Student").list().get(0)).intValue(); // 取法2
			int pageCount = (rowCount - 1) / pageSize + 1;
			for (int index = 1; index <= pageCount; index++) {
				System.out.println(String.format("***** 第%d頁 *****", index));
				students = session.createQuery("from Student order by age")
						.setFirstResult((index - 1) * pageSize)
						.setMaxResults(pageSize).list();
				for (Student std : students) {
					System.out.println(String.format("%s, %s, %s, %s", std.getId(), std.getName(), std.getEmail(), std.getAge()));
				}
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
