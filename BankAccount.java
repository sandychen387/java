
public class BankAccount {
	
	private String accountNumber;
	private String name;
	private double balance;
	
	public BankAccount(String accountNumber, String name) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = 0;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("存款" + amount + "  您的新余额： " + balance);
		}
		else {
			System.out.println("存款金额必须是正数");
		}
		
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance ) {
			balance -= amount;
			System.out.println("取款" + amount + "  您的新余额： " + balance);
		}
		else {
			System.out.println("余额不足或金额无效");
		}
	}
	
	public void transfer(BankAccount targetAccount, double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			targetAccount.balance += amount;
			System.out.println("您转账 " + amount + " 给" + targetAccount.getName() + "   现在您的新余额： " + balance);
		}else {
			System.out.println("余额不足或金额无效");
		}
		
	}

}
