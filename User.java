import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;

public class User {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  private int customerNumber;
	private int pinNumber;
	private double checkingBalanceAccount = 0;
	private double savingBalance = 0;

  // Allow user to create new accounts
  
  public User() {

    Random random = new Random();
    customerNumber = random.nextInt(999999999);
    pinNumber = random.nextInt(9999);
    
  }

	/* Set the customer number */

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

  
	/* Get the customer number */

	public int getCustomerNumber() {
		return customerNumber;
	}

	/* Set the pin number */

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	/* Get the pin number */

	public int getPinNumber() {
		return pinNumber;
	}

	/* Get Checking Account Balance */

	public double getCheckingBalance() {
		return checkingBalanceAccount;
	}

	/* Get Saving Account Balance */

	public double getSavingBalance() {
		return savingBalance;
	}

	/* Calculate Checking Account withdrawal */

	public double calcCheckingWithdraw(double amount) {
		checkingBalanceAccount = (checkingBalanceAccount - amount);
		return checkingBalanceAccount;
	}

	/* Calculate Saving Account withdrawal */

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	/* Calculate Checking Account deposit */

	public double calcCheckingDeposit(double amount) {
		checkingBalanceAccount = (checkingBalanceAccount + amount);
		return checkingBalanceAccount;
	}

	/* Calculate Saving Account deposit */

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	/* Customer Checking Account Withdraw input */

	public void getCheckingWithdrawInput() {
		System.out.println("Your Checking Account Balance: " + moneyFormat.format(checkingBalanceAccount));
		System.out.print("Amount you want to withdraw from your Checking Account: ");
		double amount = input.nextDouble();

		if ((checkingBalanceAccount - amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalanceAccount) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Saving Account Withdraw input */

	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			calcSavingWithdraw(amount);
			System.out.println("New Saving Account balance: " + savingBalance + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Checking Account Deposit input */

	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalanceAccount));
		System.out.print("Amount you want to deposit to Checking Account: ");
		double amount = input.nextDouble();

		if ((checkingBalanceAccount + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalanceAccount) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Saving Account Deposit input, used moneyFormat to present users to an ATM like format*/

	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to deposit to Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance + amount) >= 0) {
			calcSavingDeposit(amount);
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

}
