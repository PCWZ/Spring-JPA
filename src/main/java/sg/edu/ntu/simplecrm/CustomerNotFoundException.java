package sg.edu.ntu.simplecrm;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomerNotFoundException extends RuntimeException {
  CustomerNotFoundException(Long id) {
    super("Could not find customer " + id);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception ex) {
    // We can log the exception here
    // logger.error(ex.getMessage(), ex);
    // Return a generic error message
    ErrorResponse errorResponse = new ErrorResponse("Something went wrong", LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}

}
