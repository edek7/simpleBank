package pl.edwinjarosinski.simpleBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edwinjarosinski.simpleBank.model.Account;

/**
 * @author Edwin Jarosinski.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
