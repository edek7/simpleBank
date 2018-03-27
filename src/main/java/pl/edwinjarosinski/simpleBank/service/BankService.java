package pl.edwinjarosinski.simpleBank.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edwinjarosinski.simpleBank.model.Account;
import pl.edwinjarosinski.simpleBank.model.Customer;
import pl.edwinjarosinski.simpleBank.repository.AccountRepository;
import pl.edwinjarosinski.simpleBank.repository.CustomerRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author Edwin Jarosinski.
 */
@Service
@AllArgsConstructor
public class BankService {

    private final CustomerRepository customerRepository;

    @Transactional
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void createAccounts(Customer customer, List<Account.AccountType> accountTypeList) {
        for (Account.AccountType type : accountTypeList) {
            createAccountForCustomer(customer, type);
        }
    }

    public void createCustomerWithInitialAcount(Customer customer) {
        createCustomer(customer);
        createAccountForCustomer(customer, Account.AccountType.SETTLEMENT);
    }

    @Transactional
    private void createAccountForCustomer(Customer customer, Account.AccountType type) {
        Account account = new Account();
        account.setNumber(UUID.randomUUID().toString());
        account.setAccountType(type);
        customer.addAccount(account);
        customerRepository.save(customer);
    }

    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
