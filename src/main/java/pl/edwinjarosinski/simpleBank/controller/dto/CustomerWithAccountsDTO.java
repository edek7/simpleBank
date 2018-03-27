package pl.edwinjarosinski.simpleBank.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Edwin Jarosinski.
 */
@Setter
@Getter
public class CustomerWithAccountsDTO {
    private String customerName;
    private String customerPesel;
    private Collection<AccountDTO> accounts = new ArrayList<>();

    @Setter
    @Getter
    private class AccountDTO {
        private String number;
        private String accountType;
    }
}
