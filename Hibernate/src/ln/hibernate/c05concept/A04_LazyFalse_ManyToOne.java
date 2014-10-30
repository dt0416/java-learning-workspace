package ln.hibernate.c05concept;

import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.User;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 取消使用Lazy
 * 當物件已超出Session以外還需取得，此時會無法取得並出錯
 * 取消使用Lazy可在query時一併取得需要物件，但會多出額外的query
 * 
 * @author Ian Chen
 */
public class A04_LazyFalse_ManyToOne {
	public static void main(String[] args) throws Exception {
		List<User> users = getAllUsers();
		
		// 在此Session已close，必需不使用lazy才可取得到User的屬性
		// 參考User.hbm.xml裡<many-to-one name="room" class="ln.hibernate.c01hibernatedemo.pojo.Room" fetch="select" cascade="save-update" lazy="false">已加上lazy="false"
		for (User user : users) {
			System.out.println(user.getName() + ", " + user.getRoom().getAddress());
		}
	}
	
	public static List<User> getAllUsers() throws Exception {
		Session session = null;
		Transaction tx = null;
		List<User> users = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** LazyFalse *****");
			Query query = session.createQuery("from User");
			users = query.list();
			// 不使用lazy="false"，則可使用Hibernate.initialize()，如下面3行：
//			for (User user : users) {
//				Hibernate.initialize(user.getRoom());
//			}
			
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
		
		return users;
	}

}
