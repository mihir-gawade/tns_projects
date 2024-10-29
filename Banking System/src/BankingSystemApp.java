import model.*;
import service.BankingService;
import service.BankingServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BankingSystemApp {
  private static final BankingService bankingService = new BankingServiceImpl();
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      displayMenu();
      int choice = Integer.parseInt(scanner.nextLine());

      switch (choice) {
        case 1 -> addCustomer();
        case 2 -> addAccount();
        case 3 -> addBeneficiary();
        case 4 -> addTransaction();
        case 5 -> findCustomerById();
        case 6 -> listAccountsByCustomerId();
        case 7 -> listTransactionsByAccountId();
        case 8 -> listBeneficiariesByCustomerId();
        case 9 -> {
          System.out.println("Thank you for using the Banking System. Goodbye!");
          System.exit(0);
        }
        default -> System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void displayMenu() {
    System.out.println("\nBanking System");
    System.out.println("1. Add Customer");
    System.out.println("2. Add Account");
    System.out.println("3. Add Beneficiary");
    System.out.println("4. Add Transaction");
    System.out.println("5. Find Customer by Id");
    System.out.println("6. List all Accounts of specific Customer");
    System.out.println("7. List all Transactions of specific Account");
    System.out.println("8. List all Beneficiaries of specific Customer");
    System.out.println("9. Exit");
    System.out.print("Enter your choice: ");
  }

  private static void addCustomer() {
    System.out.println("Enter Customer Details:");
    System.out.print("Customer Id: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("Address: ");
    String address = scanner.nextLine();
    System.out.print("Contact No.: ");
    String contact = scanner.nextLine();

    Customer customer = new Customer(id, name, address, contact);
    bankingService.addCustomer(customer);
    System.out.println("Customer added successfully.");
  }

  private static void addAccount() {
    System.out.println("Enter Account Details:");
    System.out.print("Account Id: ");
    int accountId = Integer.parseInt(scanner.nextLine());
    System.out.print("Customer Id: ");
    int customerId = Integer.parseInt(scanner.nextLine());
    System.out.print("Account Type (Saving/Current): ");
    String type = scanner.nextLine();
    System.out.print("Balance: ");
    double balance = Double.parseDouble(scanner.nextLine());

    Account account = new Account(accountId, customerId, type, balance);
    bankingService.addAccount(account);
    System.out.println("Account added successfully.");
  }

  private static void addBeneficiary() {
    System.out.println("Enter Beneficiary Details:");
    System.out.print("Customer Id: ");
    int customerId = Integer.parseInt(scanner.nextLine());
    System.out.print("Beneficiary Id: ");
    int beneficiaryId = Integer.parseInt(scanner.nextLine());
    System.out.print("Beneficiary Name: ");
    String name = scanner.nextLine();
    System.out.print("Beneficiary Account No.: ");
    String accountNumber = scanner.nextLine();
    System.out.print("Beneficiary Bank Details: ");
    String bankDetails = scanner.nextLine();

    Beneficiary beneficiary = new Beneficiary(beneficiaryId, customerId, name, accountNumber, bankDetails);
    bankingService.addBeneficiary(beneficiary);
    System.out.println("Beneficiary added successfully.");
  }

  private static void addTransaction() {
    System.out.println("Enter Transaction Details:");
    System.out.print("Account Id: ");
    int accountId = Integer.parseInt(scanner.nextLine());
    System.out.print("Type (Deposit/Withdrawal): ");
    String type = scanner.nextLine();
    System.out.print("Amount: ");
    double amount = Double.parseDouble(scanner.nextLine());

    Transaction transaction = new Transaction(accountId, type, amount);
    bankingService.addTransaction(transaction);
    System.out.println("Transaction processed successfully.");
  }

  private static void findCustomerById() {
    System.out.print("Enter Customer Id: ");
    int customerId = Integer.parseInt(scanner.nextLine());

    Customer customer = bankingService.findCustomerById(customerId);
    if (customer != null) {
      System.out.println("Customer found: " + customer);
    } else {
      System.out.println("Customer not found.");
    }
  }

  private static void listAccountsByCustomerId() {
    System.out.print("Enter Customer Id: ");
    int customerId = Integer.parseInt(scanner.nextLine());

    List<Account> accounts = bankingService.getAccountsByCustomerId(customerId);
    if (!accounts.isEmpty()) {
      System.out.println("Accounts for Customer ID " + customerId + ":");
      accounts.forEach(System.out::println);
    } else {
      System.out.println("No accounts found for the given Customer ID.");
    }
  }

  private static void listTransactionsByAccountId() {
    System.out.print("Enter Account Id: ");
    int accountId = Integer.parseInt(scanner.nextLine());

    List<Transaction> transactions = bankingService.getTransactionsByAccountId(accountId);
    if (!transactions.isEmpty()) {
      System.out.println("Transactions for Account ID " + accountId + ":");
      transactions.forEach(System.out::println);
    } else {
      System.out.println("No transactions found for the given Account ID.");
    }
  }

  private static void listBeneficiariesByCustomerId() {
    System.out.print("Enter Customer Id: ");
    int customerId = Integer.parseInt(scanner.nextLine());

    List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(customerId);
    if (!beneficiaries.isEmpty()) {
      System.out.println("Beneficiaries for Customer ID " + customerId + ":");
      beneficiaries.forEach(System.out::println);
    } else {
      System.out.println("No beneficiaries found for the given Customer ID.");
    }
  }
}
