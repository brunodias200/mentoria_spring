package com.treinamentospring.treinamentospring.server.infrastructure;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> handleJdbcSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception, WebRequest webRequest){
        var request = ((ServletWebRequest) webRequest).getRequest().getRequestURI();
        var status = HttpStatus.CONFLICT;
        var body = new ExceptionResponse(
                status.getReasonPhrase(),
                exception.getMessage(),
                request,
                status.value(),
                LocalDateTime.now().toString()
        );
        return super.handleExceptionInternal(exception, body, new HttpHeaders(), status, webRequest);
    }
}
