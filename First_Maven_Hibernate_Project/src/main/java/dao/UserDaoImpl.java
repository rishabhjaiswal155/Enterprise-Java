package dao;

import pojos.Role;
import pojos.User;
import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;
public class UserDaoImpl implements IUserDao {

	@Override
	public String addNewUser(User user){
		String msg="User details inserted successfully!!!";
		//get the session from SesionFactory
		Session session=getSf().openSession();
		Session session1=getSf().openSession();//get the new Session
		System.out.println("same sessions ?: "+session.equals(session1));//false
			//Begin the Transaction
		Transaction tx=session.beginTransaction();
		System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//true true
		try {
			session.save(user);
			tx.commit();
			System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//true true
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			msg="User details insertion failed!!!";
			throw e;
		}finally {
			if(session!=null)
			      session.close();
			System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//false false
		}
		return msg;
	}

	@Override
	public String addNewUserwithgetCurrentSession(User user) {
		String msg=null;
		//get the session using getCurrentSession
		Session session=getSf().getCurrentSession();
		Session session1=getSf().getCurrentSession();
		System.out.println("same sessions ?: "+session.equals(session1));//true
		Transaction tx=session.beginTransaction();
		System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//true true
		try {
			//Save vs persist
			//Integer id=(Integer)session.save(user);
			//session.persist(user);
			
			//saveOrUpdate():
			//session.saveOrUpdate(user);
			
			//merge()
			User newuser=(User)session.merge(user);
			tx.commit();
		    //msg="User Details Inserted Successfully!!"+id;
			msg="User Details Inserted Successfully!!"+newuser.getUserId();
			System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//false false
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			msg="User details insertion failed!!"+user.getUserId();
			throw e;
			}
		}
		return msg;
	}

	@Override
	public User getUserDetailsbyId(int userId) {
		User user=null;//state:Transient
		Session session=getSf().getCurrentSession();//create the empty  L1 cache
		Transaction tx=session.beginTransaction();
		try {
			user=(User)session.get(User.class,userId);
			user=(User)session.get(User.class,userId);
			user=(User)session.get(User.class,userId);
			user=(User)session.get(User.class,userId);//State:persistent
			tx.commit();//Automatic dirty checking ---->session closed and destroys the L1 cache
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();//session closed and destroys the L1 cache
			throw e;
		}
		return user;//state:Detached
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users=null;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select u from User u";
			users=session.createQuery(jpql,User.class).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return users;
	}

	@Override
	public List<User> getAllUserDetailsByDateAndRole(LocalDate start, LocalDate end, Role role) {
		List<User> users=null;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select u from User u where u.regDate between :strt_date and :end_date and u.userRole=:role";
			users=session.createQuery(jpql, User.class).setParameter("strt_date", start).setParameter("end_date", end).setParameter("role", role).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public User userLogin(String email, String password) {
		User user;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select u from User u where u.email=:email and u.password=:password";
			user=session.createQuery(jpql, User.class).setParameter("email", email).setParameter("password",password).getSingleResult();
			tx.commit();
			System.out.println(user.getFirstName()+" Login Successfully!!!");
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			System.out.println("Login failed!!!");
			throw e;
		}
		return user;
	}

	@Override
	public List<String> getAllUserFirstNameRegisterAfterDate(LocalDate date) {
		List<String> names;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select u.firstName from User u where u.regDate>:date";
			names=session.createQuery(jpql,String.class).setParameter("date", date).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return names;
	}

	@Override
	public List<User> getSelectedProjectionByDateAndRole(LocalDate start, LocalDate end, Role role) {
		List<User> users;
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select new pojos.User(u.lastName,u.regAmount,u.regDate) from User u where u.regDate between :strt_date and :end_date and u.userRole=:role";
			users=session.createQuery(jpql, User.class).setParameter("strt_date", start).setParameter("end_date",end).setParameter("role", role).getResultList();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public String changePasswordByUserId(int userId, String newPassword) {
		User user=null;
		String msg="Password updation failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			 user=session.get(User.class, userId);//state:persistent
			if(user!=null) {
				user.setPassword(newPassword);
				//changing the state of Persistent entity
				 msg="Password changed Successfully of "+user.getFirstName();
			}
			else
			  System.out.println("Invalid UserId ");
			tx.commit();//Automatic dirty checking--->update query----->destroys L1 cache---->cn rets to pool----->session.close();	       
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		user.setPassword("14568");//changing state of Detached entity
		return msg;
	}

	@Override
	public String applyDiscountByDate(double discountAmt, LocalDate date) {
		List<User> users;
		String msg="Applying Discount failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			  String jpql="select u from User u where u.regDate<:dt";
			  users= session.createQuery(jpql, User.class).setParameter("dt", date).getResultList();
			  if(users!=null) {
			  users.forEach(i->i.setRegAmount(i.getRegAmount()-discountAmt));
			  msg="Applying Discount Successfull!!!";
			  }
			  tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String applyDiscountByDateBulkUpdate(double discountAmt, LocalDate date) {
		String msg="Applying Discount failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="update User u set u.regAmount=u.regAmount-:discAmt where u.regDate<:dt";
			int updatedCnt=session.createQuery(jpql).setParameter("discAmt", discountAmt).setParameter("dt", date).executeUpdate();
			msg= "Discount Applied Successfully!!! for"+updatedCnt+" users";
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String unsubscribeUser(String email) {
		User user;
		String msg="Failed to Unsubscribe!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select u from User u where u.email=:em";
			user=session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			session.delete(user);
			msg="Unsubscribe Successfully! "+user.getFirstName();
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public String deleteAllUsersByDate(LocalDate date) {
		String msg="Unsubscribing all Users failed!!!";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="delete from User u where u.regDate >:dt";
			int updatedCnt=session.createQuery(jpql).setParameter("dt", date).executeUpdate();
			msg="Unsubscribed successfully!! for "+updatedCnt+" users";
			tx.commit();
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
}
