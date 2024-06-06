package net.orgranization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception,
                                                                  WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), exception.getMessage(), request.getDescription(false),
                "ORGANIZATION_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrgCodeAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> orgCodeAlreadyExist(OrgCodeAlreadyExistException exception,
                                                            WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(), exception.getMessage(), request.getDescription(false),
                "ORGANIZATION Code already exist"
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException ex,
                                                                  org.springframework.http.HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  org.springframework.web.context.request.WebRequest request){
        Map<String,String> errors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        allErrors.forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
