package pl.edwinjarosinski.simpleBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edwinjarosinski.simpleBank.model.Customer;

/**
 * @author Edwin Jarosinski.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
