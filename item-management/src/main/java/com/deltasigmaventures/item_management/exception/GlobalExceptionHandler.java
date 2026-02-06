package com.deltasigmaventures.item_management.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice                            //Handle exceptions globally in one place and return consistent JSON error responses.
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)     //Tells Spring:Call this method when MethodArgumentNotValidException occurs,This exception happens when: @Valid fails on @RequestBody
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)   //Sets HTTP response status to 400 BAD REQUEST and indicates client sent invalid input
    public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return errors;
    }
}



/* public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
Method that handles validation errors ,Parameter ex contains all validation error details,Returns a Map<String, String> which becomes JSON */

/*Map<String, String> errors = new HashMap<>();
Creates a map to store: Field name → Error message */

//getBindingResult() = Retrieves the result of validation,Contains all errors found during request binding

//.getFieldErrors() = gets only field-level errors not class-level


/*.forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
Iterates over each field error.
err.getField() → field name (e.g., description)
err.getDefaultMessage() → validation message */