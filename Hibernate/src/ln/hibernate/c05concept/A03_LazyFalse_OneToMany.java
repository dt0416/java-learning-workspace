package ln.hibernate.c05concept;

import java.util.List;

import ln.hibernate.c01hibernatedemo.pojo.Room;
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
public class A03_LazyFalse_OneToMany {
	public static void main(String[] args) throws Exception {
		List<Room> rooms = getAllRooms();
		
		// 在此Session已close，必需不使用lazy才可取得到User的屬性
		// 參考Room.hbm.xml裡<set name="users" table="user" inverse="true" lazy="false" fetch="select">的lazy已改成false
		for (Room room : rooms) {
			System.out.println(room.getAddress());
			for (User user : room.getUsers()) {
				System.out.println(user.getName());
			}
		}
	}
	
	public static List<Room> getAllRooms() throws Exception {
		Session session = null;
		Transaction tx = null;
		List<Room> rooms = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** LazyFalse *****");
			Query query = session.createQuery("from Room");
			rooms = query.list();
			// 不使用lazy="false"，則可使用Hibernate.initialize()，如下面3行：
//			for (Room room : rooms) {
//				Hibernate.initialize(room.getUsers());
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
		
		return rooms;
	}

}
