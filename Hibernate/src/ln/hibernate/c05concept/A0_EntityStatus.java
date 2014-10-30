package ln.hibernate.c05concept;

import ln.hibernate.c01hibernatedemo.pojo.Student;
import ln.hibernate.c02hibernateutil.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ���骫��ͩR�g��
 * http://openhome.cc/Gossip/HibernateGossip/EntityObjectLifeCycle.html
 * Transient(���ɺA)�B Persistent(��[�A)�BDetached(�����A)�BRemoved
 * 
 * @author Ian Chen
 */
public class A0_EntityStatus {
	public static void main(String[] args) throws Exception {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getCurrentSession();
			tx = session.beginTransaction();

			// ***** Transient *****
			Student student = new Student(6);
			student.setAge(10);
			student.setName("Insert Data");
			
			session.save(student);
			// ***** Persistent *****
			// ����studen�w�i�JPersistent���A�A���󲧰ʬҷ|�Q�g�i��Ʈw
			student.setAge(30);
			
			tx.commit();
			student.setAge(40);
			// ***** Detached *****
			// �w�gcommit�Bsession�]�wclose
			// ����studen���󲧰ʬҤ��|�g�i��Ʈw
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
