package sg.edu.ntu.simplecrm;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  // private CustomerService customerService = new CustomerService();
  private CustomerService customerService;

  @Autowired
  public CustomerController(@Qualifier("customerServiceImpl") CustomerService customerService) {
    this.customerService = customerService;
  }

  // CREATE
  @PostMapping("")
  public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {

    Customer newCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
  }

  // READ (GET ALL)
  @GetMapping("")
  public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
    ArrayList<Customer> allCustomers = customerService.getAllCustomers();
    return new ResponseEntity<>(allCustomers, HttpStatus.OK);
  }

  // READ (GET ONE)
  // /customers/123289283942384
  // where is it in the ArrayList
  @GetMapping("{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {

  
      Customer foundCustomer = customerService.getCustomer(id);
      return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    
    
  }

  // UPDATE
  @PutMapping("{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

    try {
      Customer updatedCustomer = customerService.updateCustomer(id, customer);
      return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    } catch (CustomerNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DELETE
  @DeleteMapping("{id}")
  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {

    try {
      customerService.deleteCustomer(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (CustomerNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // NESTED ROUTE
  @PostMapping("{id}/interactions")
  public ResponseEntity<Interaction> addInteractionToCustomer(@PathVariable Long id,
      @RequestBody Interaction interaction) {
    Interaction newInteraction = customerService.addInteractionToCustomer(id, interaction);

    return new ResponseEntity<>(newInteraction, HttpStatus.CREATED);

  }

  @GetMapping("/search")
  public ResponseEntity<ArrayList<Customer>> searchCustomers(@RequestParam String firstName) {
    ArrayList<Customer> foundCustomers = customerService.searchCustomers(firstName);
    return new ResponseEntity<>(foundCustomers, HttpStatus.OK);
  }

}
