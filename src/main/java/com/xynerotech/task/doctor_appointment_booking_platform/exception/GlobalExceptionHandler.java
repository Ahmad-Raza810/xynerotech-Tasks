package com.xynerotech.task.doctor_appointment_booking_platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorResponse errorResponse=new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    //Handler for Validation error
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errors=new HashMap<>();
        BindingResult bindingResult =ex.getBindingResult();
        List<FieldError> fieldErrors=bindingResult.getFieldErrors();

        for (FieldError error:fieldErrors){
            errors.put(error.getField(),error.getDefaultMessage());
        }

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
