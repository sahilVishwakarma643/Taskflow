package com.example.springpractice.taskflow.Exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springpractice.taskflow.Exception.CustomException.RequestNotProcessedException;
import com.example.springpractice.taskflow.Exception.CustomException.ResourceNotFoundException;
import com.example.springpractice.taskflow.Exception.ErrorResponse.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)

   public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
      ErrorResponse body = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.name(), request.getRequestURI(), ex.getMessage());

      return new ResponseEntity<ErrorResponse>(body, HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(RequestNotProcessedException.class)

   public ResponseEntity<ErrorResponse> handleNotProcessed(RequestNotProcessedException exc,
         HttpServletRequest request) {
      ErrorResponse body = new ErrorResponse(
            LocalDateTime.now(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), request.getRequestURI(),
            exc.getMessage());
      return new ResponseEntity<ErrorResponse>(body, HttpStatus.BAD_REQUEST);
   }

}
