package dependency;

import org.springframework.stereotype.Component;
//singleton and eager
@Component("test")
public class TestTransport implements Transport {
	public TestTransport() {
		System.out.println("in cnstr of " +getClass());
	}

	@Override
	public void informBank(byte[] data) {
		System.out.println("informing bank using " + getClass() + " layer");

	}

}
