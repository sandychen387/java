import java.util.Scanner;

public class BankSystem {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n-----  银行系统 -----");
			System.out.println("1. 创建账户");
			System.out.println("2. 存款");
			System.out.println("3. 取款");
			System.out.println("4. 转账");
			System.out.println("5. 查询余额");
			System.out.println("6. 退出。。。");
			System.out.println("输入您的选择： ");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.print("输入账户编号： ");
				String accountNumber = sc.nextLine();
				System.out.print("输入账号所有者的姓名： ");
				String name = sc.nextLine();
				bank.createAccount(accountNumber, name);
				break;
				
			case 2:
				System.out.print("输入账户编号： ");
				accountNumber = sc.nextLine();
				BankAccount account = bank.getAccount(accountNumber);
				
				if(account  != null) {
					System.out.print("输入存款金额： ");
					double amount = sc.nextDouble();
					account.deposit(amount);
				}else {
					System.out.print("账户不存在");
				}
				break;
				
			case 3:
				System.out.print("输入账户编号： ");
				accountNumber = sc.nextLine();
				account = bank.getAccount(accountNumber);
				
				if(account != null) {
					System.out.print("输入取款金额： ");
					double amount = sc.nextDouble();
					account.withdraw(amount);
				}else {
					System.out.print("账户不存在");
				}
				break;
			case 4:
				System.out.print("输入现有账户编号： ");
				String sourceAccountNumber = sc.nextLine();
				System.out.print("输入目标账户编号： ");
				String targetAccountNumber = sc.nextLine();
				System.out.print("您要转账的金额： ");
				double transferAmount = sc.nextDouble();
				BankAccount sourceAccount = bank.getAccount(sourceAccountNumber);
				BankAccount targetAccount = bank.getAccount(targetAccountNumber);
				if(sourceAccount != null && targetAccount != null) {
					sourceAccount.transfer(targetAccount, transferAmount);
				}else {
					System.out.print("账户不存在");
				}
				break;
				
			case 5:
				System.out.print("输入账户编号： ");
				accountNumber = sc.nextLine();
				account = bank.getAccount(accountNumber);
				
				if(account != null) {
					System.out.println("您的账户余额： " + account.getBalance());
				}else {
					System.out.print("账户不存在");
				}
				break;	
				
			case 6:
				System.out.print("退出。。。 ");
				sc.close();
				return;
				
			default:
				System.out.print("无效！请输入您的选择： ");
				
			}
			
		}
	}

}
