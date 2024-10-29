package service;

import model.*;
import java.util.*;

public class BankingServiceImpl implements BankingService {
  private Map<Integer, Customer> customers = new HashMap<>();
  private Map<Integer, Account> accounts = new HashMap<>();
  private Map<Integer, Transaction> transactions = new HashMap<>();
  private Map<Integer, Beneficiary> beneficiaries = new HashMap<>();

  @Override
  public void addCustomer(Customer customer) {
    customers.put(customer.getCustomerID(), customer);
  }

  @Override
  public void addAccount(Account account) {
    accounts.put(account.getAccountID(), account);
  }

  @Override
  public void addTransaction(Transaction transaction) {
    transactions.put(transaction.getTransactionID(), transaction);
    Account account = accounts.get(transaction.getAccountID());
    if (transaction.getType().equalsIgnoreCase("Deposit")) {
      account.setBalance(account.getBalance() + transaction.getAmount());
    } else {
      account.setBalance(account.getBalance() - transaction.getAmount());
    }
  }

  @Override
  public void addBeneficiary(Beneficiary beneficiary) {
    beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary);
  }

  @Override
  public Customer findCustomerById(int id) {
    return customers.get(id);
  }

  @Override
  public List<Account> getAccountsByCustomerId(int customerId) {
    List<Account> result = new ArrayList<>();
    for (Account acc : accounts.values()) {
      if (acc.getCustomerID() == customerId)
        result.add(acc);
    }
    return result;
  }

  @Override
  public List<Transaction> getTransactionsByAccountId(int accountId) {
    List<Transaction> result = new ArrayList<>();
    for (Transaction tx : transactions.values()) {
      if (tx.getAccountID() == accountId)
        result.add(tx);
    }
    return result;
  }

  @Override
  public List<Beneficiary> getBeneficiariesByCustomerId(int customerId) {
    List<Beneficiary> result = new ArrayList<>();
    for (Beneficiary bf : beneficiaries.values()) {
      if (bf.getCustomerID() == customerId)
        result.add(bf);
    }
    return result;
  }

  @Override
  public Collection<Customer> getAllCustomers() {
    return customers.values();
  }

  @Override
  public Collection<Account> getAllAccounts() {
    return accounts.values();
  }

  @Override
  public Collection<Transaction> getAllTransactions() {
    return transactions.values();
  }

  @Override
  public Collection<Beneficiary> getAllBeneficiaries() {
    return beneficiaries.values();
  }
}
