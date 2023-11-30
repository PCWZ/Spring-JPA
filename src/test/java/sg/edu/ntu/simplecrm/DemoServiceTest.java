package sg.edu.ntu.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {

    DemoService demoService;

    @BeforeEach
    public void init() {
        System.out.println("Before each test");
        demoService = new DemoService();
    }

    @Test
    public void testAdd() {
        // 1. SETUP
        // Create the instance of the class that we want to test
        DemoService demoService = new DemoService();

        // Define the expected result
        int expectedResult = 8;

        // 2. EXECUTE
        // Call the method that we want to test
        int actualResult = demoService.add(3, 5);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "3 + 5 should be 8");
    }

    @Test
    public void testSubtract() {
        // 1. SETUP
        // Create the instance of the class that we want to test
        DemoService demoService = new DemoService();

        // Define the expected result
        int expectedResult = 2;

        // 2. EXECUTE
        // Call the method that we want to test
        int actualResult = demoService.subtract(5, 3);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "5 - 3 should be 2");
    }


    @Test
    public void testMultiply() {
        // 1. SETUP
        // Create the instance of the class that we want to test
        DemoService demoService = new DemoService();

        // Define the expected result
        int expectedResult = 15;

        // 2. EXECUTE
        // Call the method that we want to test
        int actualResult = demoService.multiply(5, 3);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "5 * 3 should be 15");
    }
    @DisplayName("divide")
     @Test
    public void testDivide() {
        // 1. SETUP
        // Create the instance of the class that we want to test
        DemoService demoService = new DemoService();

        // Define the expected result
        int expectedResult = 2;

        // 2. EXECUTE
        // Call the method that we want to test
        int actualResult = demoService.divide(6, 3);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertEquals(expectedResult, actualResult, "6 / 3 should be 2");
    }

      @Test
    public void testEven() {
        // 1. SETUP
        // Create the instance of the class that we want to test
        DemoService demoService = new DemoService();

        // Define the expected result
        // int expectedResult = 2;

        // 2. EXECUTE
        // Call the method that we want to test
        boolean actualResult = demoService.isEven(6);

        // 3. ASSERT
        // Compare the actual result with the expected result
        assertTrue(actualResult, "6 / 3 should be 2");
    }
        

}
