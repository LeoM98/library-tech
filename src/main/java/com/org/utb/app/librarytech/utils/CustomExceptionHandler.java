package com.org.utb.app.librarytech.utils;

import com.org.utb.app.librarytech.dto.ResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handle TransactionSystemException in order to show an appropiate message
     * errror.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<ResponseDto> handle(TransactionSystemException ex) {

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Unidentified error.");

        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (ex.getRootCause() instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException =
                    (ConstraintViolationException) ex.getRootCause();

            status = getFirstMessage(constraintViolationException, responseDto);
        }

        return new ResponseEntity<>(responseDto, status);
    }

    /**
     * Handle DataIntegrityViolationException in order to show an appropiate
     * message errror.
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseDto handle(DataIntegrityViolationException ex) {

        return new ResponseDto("Username already exist.");
    }

    /**
     * Regarding some of the errors have an special response codes each time the
     * response is showing one error at time.
     *
     * @param exception
     * @param responseDto
     * @return
     */
    private HttpStatus getFirstMessage(ConstraintViolationException exception,
                                       ResponseDto responseDto) {
        Set<ConstraintViolation<?>> constraintViolations =
                exception.getConstraintViolations();

        if (!constraintViolations.isEmpty()) {
            ConstraintViolation constraintViolation =
                    constraintViolations.iterator().next();
            constraintViolation.getConstraintDescriptor().getAnnotation();

            String message =
                    String.format("Field '%s' Value '%s': Message '%s'",
                            constraintViolation.getPropertyPath(),
                            constraintViolation.getInvalidValue(),
                            constraintViolation.getMessage());

            responseDto.setMessage(message);
        }

        return HttpStatus.BAD_REQUEST;
    }

}
