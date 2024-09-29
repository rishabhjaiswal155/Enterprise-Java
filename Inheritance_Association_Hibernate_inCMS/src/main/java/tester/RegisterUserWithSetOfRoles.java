package tester;

import static utils.HibernateUtils.getSf;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;

import dao.RoleDaoimpl;
import dao.UserDaoImpl;
import pojos.Role;
import pojos.User;
import pojos.UserRole;

public class RegisterUserWithSetOfRoles {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao=new UserDaoImpl();
			RoleDaoimpl roleDao=new RoleDaoimpl();
			System.out.println("Enter UserDetails:firstName,lastName,email,password");
			User user=new User(sc.next(), sc.next(), sc.next(), sc.next());
			sc.nextLine();
			System.out.println("Enter roles from: "+Arrays.toString(UserRole.values()));
			Set<Role> roles=Arrays.stream(sc.nextLine().split(" ")).map(s->UserRole.valueOf(s.toUpperCase())).map(r->roleDao.findRoleByroleName(r)).collect(Collectors.toSet());
			System.out.println(userDao.registerUserWithSetOfRoles(user, roles));
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
