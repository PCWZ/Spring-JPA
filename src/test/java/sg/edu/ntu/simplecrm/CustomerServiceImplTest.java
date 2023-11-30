package sg.edu.ntu.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceImplTest {

  // We need to mock the CustomerRepository
  // Because we don't want to test the repository layer
  @Mock
  private CustomerRepository customerRepository;

  @InjectMocks // Inject the mocks as dependencies into CustomerServiceImpl
  CustomerServiceImpl customerService;

  @Test 
  public void createCustomerTest(){

    //1.SETUP / ARRANGE
    // Customer custoemr = new Customer();
    Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com").contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

    // Mock the save method of the customer repository
    when((customerRepository.save(customer))).thenReturn(customer);

    // 2. EXECUTE
    // Call the method that we want to test
    Customer savedCustomer = customerService.createCustomer(customer);

    // 3. ASSERT
    // Compare the actual result with the expected result
    assertEquals(customer, savedCustomer, "The saved customer should be the same as the new customer");

    // Also verify that the save method of the customer repository is called once
    verify(customerRepository, times(1)).save(customer);
  }

  @Test
public void getCustomerTest() {
    // 1. SETUP
    // Create a new customer
    Customer customer = Customer.builder().firstName("Clint").lastName("Barton").email("clint@avengers.com")
        .contactNo("12345678").jobTitle("Special Agent").yearOfBirth(1975).build();

    Long customerId = 1L;

    when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

    // 2. EXECUTE
    Customer retrievedCustomer = customerService.getCustomer(customerId);

    // 3. ASSERT
    assertEquals(customer, retrievedCustomer);

}

@Test
void testGetCustomerNotFound() {
    Long customerId = 1L;
    when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

    assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(customerId));
}
  
}
