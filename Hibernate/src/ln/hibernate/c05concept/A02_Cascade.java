package ln.hibernate.c05concept;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ln.hibernate.c01hibernatedemo.pojo.Room;
import ln.hibernate.c01hibernatedemo.pojo.User;
import ln.hibernate.c02hibernateutil.HibernateUtil;

/**
 * 示範使用cascade
 * 必須在*.hbm.xml增加cascade="...", 此範例在User.hbm.xml增加cascade="save-update"
 * 當儲存User的時候, Room也自動儲存
 * 假如沒使用cascade則Room須自行儲存否則會出錯
 * 
 * @author Ian Chen
 */
public class A02_Cascade {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			System.out.println("***** Cascade *****");
			Room room = new Room();
			room.setAddress("taipei");
			User user = new User();
			user.setName("User1");
			user.setRoom(room);
			
			// 當沒使用cascade則需多下此行
//			session.save(room);
			session.save(user); // 有使用cascade則只要這行就會自動儲存room

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
