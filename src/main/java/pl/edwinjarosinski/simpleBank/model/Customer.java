package pl.edwinjarosinski.simpleBank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Edwin Jarosinski.
 */
@Entity
public class Customer {
    @Setter
    @Id
    @GeneratedValue(generator = "flamenco_seq")
    @SequenceGenerator(name = "flamenco_seq", initialValue = 1000, allocationSize = 1)
    private Long id;

    @Column(unique = true, nullable = false, length = 11)
    @Setter
    @Getter
    private String pesel;
    @Column(nullable = false)
    @Setter
    @Getter
    private String name;

    @OneToMany
    private Set<Account> accounts = new HashSet<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
