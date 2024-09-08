package pojo;

public class BankAccount {
//id | name | type | bal
	private int actNo;
	private String customerName;
	private String type;
	private double balance;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getActNo() {
		return actNo;
	}

	public void setActNo(int actNo) {
		this.actNo = actNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [actNo=" + actNo + ", customerName=" + customerName + ", type=" + type + ", balance="
				+ balance + "]";
	}
	
}
