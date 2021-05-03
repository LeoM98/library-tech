/*
package com.org.utb.app.librarytech.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component
@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponseData> handleError(HttpServletRequest req, Exception e) {
        log.error("Request - {}", req.getRequestURL());
        log.error("Raised - {}", e.getMessage());
        log.error("Error - {}", e.toString());
        ExceptionResponseData exceptionResponseData = new ExceptionResponseData();
        exceptionResponseData.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionResponseData.setMessage("Error durante el proceso...");
        return new ResponseEntity<>(exceptionResponseData, HttpStatus.BAD_REQUEST);
    }

}
*/
