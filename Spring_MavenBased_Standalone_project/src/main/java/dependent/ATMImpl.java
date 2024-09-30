package dependent;



import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;//=new HttpTransport();//dep
  public ATMImpl() {
	  System.out.println("in cnstr of " +getClass().getName()+" "+myTransport);	  
  }
		private ATMImpl(Transport t1234) {
		myTransport=t1234;
		System.out.println("in cnstr of " +getClass().getName()+" "+myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing "+amt);
		byte[] data=("depositing "+amt).getBytes();
		myTransport.informBank(data);
	}
	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing "+amt);
		byte[] data=("withdrawing "+amt).getBytes();
		myTransport.informBank(data);
	}
	//setter Based Dependency Injection (D.I)
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter "+this.myTransport);
	}
	
	//init method
	public void anyInit() {
		System.out.println("in init of "+getClass().getName()+" for "+myTransport);
	}
	
	//destroy method
	public void anyDestroy() {
		System.out.println("in destroy of "+getClass().getName()+" for "+myTransport);
	}
	
	public static ATMImpl myFactory(Transport t123) {
		System.out.println("in myFactory of "+t123);
		return new ATMImpl(t123);
	}
}
