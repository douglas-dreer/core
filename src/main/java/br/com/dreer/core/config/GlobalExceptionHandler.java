package br.com.dreer.core.config;

import br.com.dreer.core.enums.StatusOperationType;
import br.com.dreer.core.exceptions.BusinessException;
import br.com.dreer.core.exceptions.MessageErrorDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<MessageErrorDTO> handleBusinessException(BusinessException e) {
        MessageErrorDTO errorDTO = new MessageErrorDTO(e.getMessage(), StatusOperationType.WARNING);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<MessageErrorDTO> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = hasErrorDataIntegrityViolation(e)
                ? "Duplicate entry detected. A document with the same information already exists."
                : "Data integrity error. Please ensure all required fields are correctly filled.";

        MessageErrorDTO errorDTO = new MessageErrorDTO(message, StatusOperationType.ERROR);
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<MessageErrorDTO> handleException(Exception e) {
        MessageErrorDTO errorDTO = new MessageErrorDTO("An unexpected error has occurred. Please try again later.", StatusOperationType.ERROR);
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean hasErrorDataIntegrityViolation(Exception e) {
        return !Objects.isNull(e) && e.getCause().getMessage().contains("Unique index or primary key violation");
    }
}
