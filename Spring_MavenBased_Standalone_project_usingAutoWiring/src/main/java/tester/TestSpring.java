package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {
	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean-config.xml")){
			System.out.println("Spring Container Up and Running!!!");
			ATMImpl atm1=ctx.getBean("my_atm",ATMImpl.class);
			atm1.deposit(1000);
			ATMImpl atm2=ctx.getBean("my_atm",ATMImpl.class);
			atm1.withdraw(1000);
			System.out.println("is same?:"+(atm1==atm2));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
