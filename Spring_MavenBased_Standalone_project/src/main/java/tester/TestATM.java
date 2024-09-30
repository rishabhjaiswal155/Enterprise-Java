package tester;

import dependency.SoapTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		//dependent obj
		ATMImpl ref1=new ATMImpl();
		ref1.setMyTransport(new SoapTransport());
		ref1.deposit(1000);
		
	}

}
