import java.util.Random;
public class BankAccount {
	private String accountNumber = "";
	private double checkingBalance = 0;
	private double savingsBalance = 0;
	private static int numberOfAccounts = 0;
	private static double totalAmountOfMoney = 0;
	private static String accountNumberGenerater() {
		String str = "";
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			str += r.nextInt(10);
		}
		return str;
	}
	
	public BankAccount(String accountNumber, double checkingBalance, double savingsBalance) {
		this.accountNumber = BankAccount.accountNumberGenerater();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		numberOfAccounts ++;
	}
	
	public BankAccount() {
		this.accountNumber = BankAccount.accountNumberGenerater();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		numberOfAccounts ++;
	}
	
	public BankAccount(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
		numberOfAccounts ++;
	}

	public BankAccount(String accountNumber, double checkingBalance) {
		super();
		this.accountNumber = accountNumber;
		this.checkingBalance = checkingBalance;
		numberOfAccounts ++;
	}
	
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void deposit(String account, double money) {
		if(account.equals("checking")) {
			this.checkingBalance += money;
			System.out.printf("Deposit $ %.2f from %s, %s account balance: $ %.2f \n", money, account,account, this.checkingBalance);
		}
		else if(account.equals("saving")) {
			this.savingsBalance += money;
			System.out.printf("Deposit $ %.2f from %s, %s account balance: $ %.2f \n", money, account,account, this.savingsBalance);
		}
		totalAmountOfMoney += money;
	}
	
	public void withdraw(String account, double money) {
		if(account.equals("checking")) {
			if (money > this.checkingBalance) {
				System.out.println("Please check your checking balance first. \n");
			}
			else {
				this.checkingBalance -= money;
				totalAmountOfMoney -= money;
				System.out.printf("Withdraw $ %.2f from %s, %s account balance: $ %.2f \n", money, account,account, this.checkingBalance);
			}
		}
		else if(account.equals("saving")) {
			if (money > this.savingsBalance) {
				System.out.println("Please check your saving balance first.");
			}
			else {
				this.savingsBalance -= money;
				totalAmountOfMoney -= money;
				System.out.printf("Withdraw $ %.2f from %s, %s account balance: $ %.2f \n", money, account, account, this.savingsBalance);
			}
		}
	}
	
	public void displayAccountBalance() {
		System.out.printf("Checking account balance: $ %.2f \n Saving account balance: $ %.2f \n Total balance: $ %.2f", this.checkingBalance, this.savingsBalance, totalAmountOfMoney);
	}
	
}
