package dao;

import pojos.Role;
import pojos.UserRole;

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

	@Override
	public Role findRoleByroleName(UserRole roleName) {
		Role role;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String JPQL="select r from Role r where r.roleName=:nm";
			 role=session.createQuery(JPQL, Role.class).setParameter("nm", roleName).getSingleResult();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return role;
		}

}
