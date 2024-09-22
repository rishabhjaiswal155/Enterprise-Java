package dao;

import pojos.User;
import static utils.HibernateUtils.*;
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
		String msg="User Details Inserted Successfully!!";
		//get the session using getCurrentSession
		Session session=getSf().getCurrentSession();
		Session session1=getSf().getCurrentSession();
		System.out.println("same sessions ?: "+session.equals(session1));//true
		Transaction tx=session.beginTransaction();
		System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//true true
		try {
			session.save(user);
			tx.commit();
			System.out.println("is open "+session.isOpen()+" and connected to DB "+session.isConnected());//false false
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			msg="User details insertion failed!!";
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
			user=(User)session.get(User.class,userId);//State:persistent
			tx.commit();//Automatic dirty checking ---->session closed and destroys the L1 cache
		}catch(RuntimeException e) {
			if(tx!=null)
				tx.rollback();//session closed and destroys the L1 cache
			throw e;
		}
		return user;//state:Detached
	}

}
