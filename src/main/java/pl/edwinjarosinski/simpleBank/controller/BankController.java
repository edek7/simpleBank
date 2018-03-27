package pl.edwinjarosinski.simpleBank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edwinjarosinski.simpleBank.controller.dto.CustomerDTO;
import pl.edwinjarosinski.simpleBank.controller.dto.CustomerWithAccountsDTO;

import java.util.Collection;

/**
 * @author Edwin Jarosinski.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankFacade bankFacade;

    @PostMapping("/registerCustomer")
    public void registerCustomer(@RequestBody CustomerDTO customerDTO) {
        bankFacade.registerCustomer(customerDTO);
    }

    @GetMapping("/customersWithAccounts")
    public Collection<CustomerWithAccountsDTO> customersWithAccounts() {
        return bankFacade.getCustomersWithAccounts();
    }
}
