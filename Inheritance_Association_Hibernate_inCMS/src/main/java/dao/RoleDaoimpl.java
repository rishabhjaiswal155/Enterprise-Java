package dao;

import pojos.Role;
import org.hibernate.*;
import static utils.HibernateUtils.*;

public class RoleDaoimpl implements IRoleDao {

	@Override
	public String addNewRole(Role role) {
		String msg="Adding New Role Failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(role);
			msg="New Role Added successfully!! with roleId="+role.getId();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
