package dao;

import static utils.HibernateUtils.getSf;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.User;
public class AddressDaoImpl implements IAddressDao {

	@Override
	public String assignUserAddress(long userId, Address address) {
		String msg="Assigning User Address failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			User user=session.get(User.class, userId);
			if(user!=null) {
				//creting link between Address----->User unidirectional
				address.setUser(user);
				session.persist(address);
				msg="Assigning User Address sucessfully for UserId:"+user.getId();
			}
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
