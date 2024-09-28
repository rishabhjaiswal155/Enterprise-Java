package tester;
import org.hibernate.*;

import dao.AddressDaoImpl;
import pojos.Address;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class AssignUserAddressByUserId {

	public static void main(String[] args) {
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			AddressDaoImpl addressDao=new AddressDaoImpl();
			System.out.println("Enter USerId");
			long userId=sc.nextLong();
			System.out.println("Enter Address Details: AddressLine1,AddressLine2,city,state,country,zipCode");
			sc.nextLine();
			String AddressLine1=sc.nextLine();
			String AddressLine2=sc.nextLine();
			String city=sc.nextLine();
			String state=sc.nextLine();
			String country =sc.nextLine();
			String zipCode=sc.nextLine();
			System.out.println(addressDao.assignUserAddress(userId,new Address(AddressLine1, AddressLine2, city, state, country, zipCode)));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}

}
