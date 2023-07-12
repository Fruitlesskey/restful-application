package com.example.restfulapplication.handler;

import com.example.restfulapplication.common.ApiError;
import com.example.restfulapplication.exception.EmployeeException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponse(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Object> handleEmployeeException(EmployeeException exception) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getMessage());
        apiError.setMessage(exception.getMessage());
        return buildResponse(apiError);
        
    }
}
