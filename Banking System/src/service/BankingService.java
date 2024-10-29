package service;

import model.*;
import java.util.*;

public interface BankingService {
  void addCustomer(Customer customer);

  void addAccount(Account account);

  void addTransaction(Transaction transaction);

  void addBeneficiary(Beneficiary beneficiary);

  Customer findCustomerById(int id);

  List<Account> getAccountsByCustomerId(int customerId);

  List<Transaction> getTransactionsByAccountId(int accountId);

  List<Beneficiary> getBeneficiariesByCustomerId(int customerId);

  Collection<Customer> getAllCustomers();

  Collection<Account> getAllAccounts();

  Collection<Transaction> getAllTransactions();

  Collection<Beneficiary> getAllBeneficiaries();
}
