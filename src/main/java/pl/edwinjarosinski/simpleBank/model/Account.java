package pl.edwinjarosinski.simpleBank.model;

import lombok.Setter;

import javax.persistence.*;

/**
 * @author Edwin Jarosinski.
 */
@Entity
public class Account {
    @Setter
    @Id
    @GeneratedValue(generator = "flamenco_seq")
    @SequenceGenerator(name = "flamenco_seq", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String number;

    @Setter
    private AccountType accountType;

    public enum AccountType {
        SAVINGS,
        SETTLEMENT
    }
}
