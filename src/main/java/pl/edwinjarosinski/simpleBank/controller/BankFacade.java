package pl.edwinjarosinski.simpleBank.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.edwinjarosinski.simpleBank.controller.dto.CustomerDTO;
import pl.edwinjarosinski.simpleBank.controller.dto.CustomerWithAccountsDTO;
import pl.edwinjarosinski.simpleBank.model.Customer;
import pl.edwinjarosinski.simpleBank.service.BankService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Edwin Jarosinski.
 */
@Service
@AllArgsConstructor
class BankFacade {

    private final BankService bankService;
    private final ModelMapper mapper;

    void registerCustomer(CustomerDTO customerDTO) {
        bankService.createCustomer(mapper.map(customerDTO, Customer.class));
    }

    Collection<CustomerWithAccountsDTO> getCustomersWithAccounts() {
        return bankService.getCustomers()
                .stream()
                .map(customer -> mapper.map(customer, CustomerWithAccountsDTO.class))
                .collect(Collectors.toList());
    }
}
