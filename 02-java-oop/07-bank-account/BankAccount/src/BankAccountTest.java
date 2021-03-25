
public class BankAccountTest {
 public static void main(String[] args) {
	BankAccount account1 = new BankAccount();
	account1.deposit("checking", 100.20);
	account1.withdraw("checking", 20.20);
	account1.deposit("saving", 50);
	account1.withdraw("saving", 80);
	account1.displayAccountBalance();
}
}
