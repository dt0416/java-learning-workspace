package ln.hibernate.c04hql;

import java.util.Iterator;
import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

/**
 * HQL重點
 * 1. from是針對物件而非Table, 物件有大小寫之分
 * 2. 除了物件以外其餘關鍵字建議都用小寫
 * 3. hibernate建議每個Table都有不含業務邏輯的PK(儘供hibernate使用)
 * 4. 在table有設定外來鍵可以不用在from裡列出關聯的table, 即可取得關聯table的欄位, 或在where也可直接使用
 * 
 * 常用Session、Trasaction取得及關閉Template
 * 
 * @author Ian Chen
 */
public class A01_CommonTemplate {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();
			
			/**
			 * 以下為查詢及其他程式區塊
			 */
			{
				System.out.println("***** HQL *****");
				Query query = session.createQuery("from Student");
				List<Student> students = query.list();
				Iterator<Student> iterator = students.iterator();
				while(iterator.hasNext()) {
				Student std = iterator.next();
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
