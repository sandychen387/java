import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private Map<String, BankAccount> accounts = new HashMap<>();
	
	public void createAccount(String accountNumber, String name) {
		if(accounts.containsKey(accountNumber)) {
			System.out.println("账户编号已存在。");
		}
		else {
			accounts.put(accountNumber, new BankAccount(accountNumber, name));
			System.out.println("创建了一个新账户，编号是：" + accountNumber + "。");
		}
	}
	
	public BankAccount getAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}
}
