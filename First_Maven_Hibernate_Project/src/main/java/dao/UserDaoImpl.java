package dao;

import pojos.User;
import static utils.HibernateUtils.*;
import org.hibernate.*;
public class UserDaoImpl implements IUserDao {

	@Override
	public String addNewUser(User user) {
		String msg="User details inserted successfully!!!";
		//get the session from SesionFactory
		Session session=getSf().openSession();
		//Begin the Transction
		Transaction tx=session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			msg="User details insertion failed!!!";
		}finally {
			if(session!=null)
			      session.close();
		}
		return msg;
	}

}
