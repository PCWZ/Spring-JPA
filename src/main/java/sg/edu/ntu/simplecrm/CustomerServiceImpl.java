package sg.edu.ntu.simplecrm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  // private CustomerRepository customerRepository = new CustomerRepository();
  // @Autowired
  private CustomerRepository customerRepository;
  private InteractionRepository interactionRepository;

  @Autowired
  public CustomerServiceImpl(CustomerRepository customerRepository, InteractionRepository interactionRepository) {
    this.customerRepository = customerRepository;
    this.interactionRepository = interactionRepository;
  }

  // Create
  @Override
  public Customer createCustomer(Customer customer) {
    Customer newCustomer = customerRepository.save(customer);
    return newCustomer;
  }

  // Get One
  // @Override
  // public Customer getCustomer(Long id) {
  //   Customer foundCustomer = customerRepository.findById(id).get();
  //   return foundCustomer;
  // }
@Override
public Customer getCustomer(Long id) {
    Optional<Customer> optionalCustomer = customerRepository.findById(id);
    if (optionalCustomer.isPresent()) {
        // If the Optional contains a value, unwrap it and return the Customer object
        Customer foundCustomer = optionalCustomer.get();
        return foundCustomer;
    }

    throw new CustomerNotFoundException(id);
}


  // Get All
  @Override
  public ArrayList<Customer> getAllCustomers() {
    List<Customer> allCustomers = customerRepository.findAll();
    return (ArrayList<Customer>) allCustomers;
  }

  // Update
  @Override
  public Customer updateCustomer(Long id, Customer customer) {

    // Retrieve customer from DB
    Customer customerToUpdate = customerRepository.findById(id).get();

    // Update the fields
    customerToUpdate.setFirstName(customer.getFirstName());
    customerToUpdate.setLastName(customer.getLastName());
    customerToUpdate.setEmail(customer.getEmail());
    customerToUpdate.setContactNo(customer.getContactNo());
    customerToUpdate.setJobTitle(customer.getJobTitle());
    customerToUpdate.setYearOfBirth(customer.getYearOfBirth());
    return customerRepository.save(customerToUpdate);
  }

  // Delete
  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Interaction addInteractionToCustomer(Long id, Interaction interaction) {
    // Retrieve customer
    Customer selectedCustomer = customerRepository.findById(id).get();
    // add the customer to the interaction
    interaction.setCustomer(selectedCustomer);
    return interactionRepository.save(interaction);

  }

  @Override
public ArrayList<Customer> searchCustomers(String firstName) {
    List<Customer> foundCustomers = customerRepository.findByFirstName(firstName);
    return (ArrayList<Customer>) foundCustomers;
}

}