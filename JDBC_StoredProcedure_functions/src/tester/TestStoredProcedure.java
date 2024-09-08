package tester;

import java.util.Scanner;

import dao.BankAccountDaoImplementation;

public class TestStoredProcedure {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			BankAccountDaoImplementation bkDao=new BankAccountDaoImplementation();
			System.out.println("Enter src Account number,Destination Account number and Amount to transfer");
			System.out.println(bkDao.transferFunds(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
			bkDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
