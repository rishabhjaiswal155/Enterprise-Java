package tester;
import org.hibernate.*;

import dao.RoleDaoimpl;
import pojos.Role;
import pojos.UserRole;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class AddNewRole {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			RoleDaoimpl roleDao=new RoleDaoimpl();
			System.out.println("Enter roleName:");
			System.out.println(roleDao.addNewRole(new Role(UserRole.valueOf(sc.next().toUpperCase()))));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

}
