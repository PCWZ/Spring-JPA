package sg.edu.ntu.simplecrm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// Some nice guy wrote the code for us
// @Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Custom query to find all customers with a certain first name
    List<Customer> findByFirstName(String firstName);

}
