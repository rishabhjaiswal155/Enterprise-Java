package dependent;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dependency.Transport;
//singleton and eager
@Component("my_atm")
public class ATMImpl implements ATM {
	
	@Autowired// default byType
	@Qualifier("httpTransport") //byName
	private Transport myTransport;//=new HttpTransport();//dep
  public ATMImpl() {
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
	
	//init method
	@PostConstruct
	public void anyInit() {
		System.out.println("in init of "+getClass().getName()+" for "+myTransport);
	}
	
	//destroy method
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy of "+getClass().getName()+" for "+myTransport);
	}
}
