package io.github.mszychiewicz.triperserver.api;

import io.github.mszychiewicz.triperserver.domain.exception.TripNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class TripExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TripNotFoundException.class)
  public ResponseEntity<Object> handleAccountNotFoundException(
      TripNotFoundException ex) {
    String body = ex.getMessage();
    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }
}
