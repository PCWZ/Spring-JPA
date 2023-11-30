package sg.edu.ntu.simplecrm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

  private CustomerRepository customerRepository;

  @Autowired
  public DataLoader(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @PostConstruct
  public void loadData() {
    // Clear the db
    customerRepository.deleteAll();

    // load data
    customerRepository.save(new Customer("Bruce", "Banner"));
    customerRepository.save(new Customer("Peter", "Parker"));
    customerRepository.save(new Customer("Stephen", "Strange"));

  }

}
