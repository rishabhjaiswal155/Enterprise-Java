package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.*;
public class UserDaoImpl implements IUserDao {

	@Override
	public String addNewUser(User user) {
		String msg="New User insertion failed!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(user);
			msg="New User added successfully!!! with userId "+user.getId();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
