package pl.edwinjarosinski.simpleBank.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.edwinjarosinski.simpleBank.controller.dto.CustomerDTO;
import pl.edwinjarosinski.simpleBank.model.Customer;
import pl.edwinjarosinski.simpleBank.service.BankService;

import static org.junit.Assert.*;

/**
 * @author Edwin Jarosinski.
 */
public class BankFacadeUnitTest {



    @Test
    public void givenCustomerDTO_whenRegisterCustomer_thenBankServiceInvokedProperly() throws Exception {
        // given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("Tomasz");
        customerDTO.setPesel("1234567890");

        BankService mock = Mockito.mock(BankService.class);
        BankFacade bankFacade = new BankFacade(mock, new ModelMapper());

        // when
        bankFacade.registerCustomer(customerDTO);

        // then
        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        Mockito.verify(mock).createCustomer(captor.capture());
        assertEquals("Tomasz", captor.getValue().getName());
        assertEquals("1234567890", captor.getValue().getPesel());
    }

}