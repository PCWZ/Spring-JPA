package sg.edu.ntu.simplecrm;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
   @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
    ErrorResponse errorResponse = new ErrorResponse("Item does not exist.", LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
}

// VALIDATION EXCEPTION HANDLER
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

    // Get a list of all validation errors from the exception object
    List<ObjectError> validationErrors = ex.getBindingResult().getAllErrors();

    // Create a StringBuilder to store all error messages
    StringBuilder sb = new StringBuilder();

    // Loop through all errors and append error messages to StringBuilder
    for (ObjectError error : validationErrors) {
        sb.append(error.getDefaultMessage() + ". ");
    }

    ErrorResponse errorResponse = new ErrorResponse(sb.toString(), LocalDateTime.now());
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
}
}
