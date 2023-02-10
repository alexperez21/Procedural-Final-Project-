import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.ArrayList;

// Random account number generator

public class Bank {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
  ArrayList<User> accounts = new ArrayList<User>();
  int accountIndex = -1;

	 HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

  public Bank() {}

  public void addAccount(User account) {
    accounts.add(account);
  }

// User creates bank account and inputs customer number
  
	public void getLogin() throws IOException {
		int x = 1;

		do {
			try {
        System.out.println("Welcome to the Bank of Dhruva!");
        System.out.println("Would you like to create an account with us? (Y/N) ");
        System.out.println("Type 1 - yes");
        System.out.println("Type 2 - no");

        int yesOrNo = menuInput.nextInt();
        
// If user selects yes, account is created
        
        if(yesOrNo == 1) {
          User newAccount = new User();
          addAccount(newAccount);
          System.out.println("Your Customer Number is " + newAccount.getCustomerNumber());
          System.out.println("Your Customer Number is " + newAccount.getPinNumber());
        }
//Checking for pin number
        
        for(int i = 0; i < accounts.size(); i++) {
          data.put(accounts.get(i).getCustomerNumber(), accounts.get(i).getPinNumber());
        }

// User enters customer number
        
				System.out.print("Enter Your Customer Number: ");
        User newAccount = new User();
				newAccount.setCustomerNumber(menuInput.nextInt());
        
// User enters pin number 
        
				System.out.print("Enter Your Pin Number: ");
				newAccount.setPinNumber(menuInput.nextInt());
        accounts.add(newAccount);
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x = 2;
			}

// Verifies that customer number is correct
      
			for (Entry<Integer, Integer> entry : data.entrySet()) {
        accountIndex++;
				if (entry.getKey() == accounts.get(accounts.size()-1).getCustomerNumber() && entry.getValue() == accounts.get(accounts.size()-1).getPinNumber()) {
					userGetAccountType();
				}
			}
			System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
		} while (x == 1);
	}

	/* Display Account Type Menu with selection */

	public void userGetAccountType() {
		System.out.println("Would you like the access your Savings or Checking Account?: ");
		System.out.println("#1 Saving Account");
		System.out.println("#2 Checking Account");
		System.out.println("#3 Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		  if(selection == 1) {
			userGetSaving();

    } else if(selection == 2){
			userGetChecking();


    } else if(selection == 3){
			System.out.println("Thank You for using Bank of Dhruva, bye.");
        accountIndex = 0;
    }

		  else {
			  System.out.println("\n" + "Invalid Choice." + "\n");
			  userGetAccountType();
		}
	}

	/* Display Checking Account Menu with selections */

	public void userGetChecking() {
		System.out.println("You Selected Checking Account: ");
		System.out.println("#1 Withdraw Balance");
		System.out.println("#2 Deposit Funds");
		System.out.println("#3 View Funds");
		System.out.println("#4 Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		   if(selection == 1) {
        accounts.get(accountIndex).getCheckingWithdrawInput();
			userGetAccountType();
     }

		else if(selection == 2) {
      accounts.get(accountIndex).getCheckingDepositInput();
			userGetAccountType();
    }

		  else if(selection == 3) {
        System.out.println("Checking Account Balance: " + moneyFormat.format(accounts.get(accountIndex).getCheckingBalance()) + "\n");
			userGetAccountType();
      }

		  else if(selection == 4){
			System.out.println("Thank You for using Bank of Drhuva, bye.");
        accountIndex = 0;
      }

		  else {
			System.out.println("\n" + "Invalid choice." + "\n");
			userGetChecking();
		}
	}

	/* Display Saving Account Menu with selections */

	public void userGetSaving() {
		System.out.println("You Selected Saving Account: ");
		System.out.println("#1 Withdraw Funds");
		System.out.println("#2 Deposit Funds");
		System.out.println("#3 View Funds");
		System.out.println("#4 Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		if (selection == 1) {
      accounts.get(accountIndex).getSavingWithdrawInput();
			userGetAccountType();
    }

		else if(selection == 2) {
			accounts.get(accountIndex).getSavingDepositInput();
			userGetAccountType();
    }

		else if (selection == 3){
      System.out.println("Saving Account Balance: " + moneyFormat.format(accounts.get(accountIndex).getSavingBalance()) + "\n");
			userGetAccountType();
    }

		else if (selection == 4) {
			System.out.println("Thank You for using Bank of Dhruva, bye.");
      accountIndex = 0;
    }

		else {
			System.out.println("\n" + "Invalid choice." + "\n");
			userGetSaving();
		}
	}

	int selection;
}
