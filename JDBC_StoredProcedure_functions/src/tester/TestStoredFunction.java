package tester;

import java.util.Scanner;

import dao.BankAccountDaoImplementationStoredFunction;

public class TestStoredFunction {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			BankAccountDaoImplementationStoredFunction bkDao=new BankAccountDaoImplementationStoredFunction();
			System.out.println("Enter src Account number,Destination Account number and Amount to transfer");
			System.out.println(bkDao.transferFunds(sc.nextInt(),sc.nextInt(),sc.nextDouble()));
			bkDao.cleanUp();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
