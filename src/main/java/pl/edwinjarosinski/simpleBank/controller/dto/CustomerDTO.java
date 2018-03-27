package pl.edwinjarosinski.simpleBank.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Edwin Jarosinski.
 */
@Setter
@Getter
public class CustomerDTO {
    private String name;
    private String pesel;
}
