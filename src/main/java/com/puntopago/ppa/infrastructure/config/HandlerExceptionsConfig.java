package com.puntopago.ppa.infrastructure.config;

import com.puntopago.ppa.application.exceptions.general.NotFoundException;
import com.puntopago.ppa.infrastructure.config.responses.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RequiredArgsConstructor
@RestControllerAdvice
public class HandlerExceptionsConfig {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return new ErrorResponse(ex.getMessage(), ex.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorResponse response = new ErrorResponse();

        if (!ex.getBindingResult().getFieldErrors().isEmpty()) {
            FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
            String fieldName = fieldError.getField();
            String constraintType = fieldError.getCode();
            String error = "The field ";
            switch (Objects.requireNonNull(constraintType)) {
                case "NotNull":
                    error += fieldName+" can not be null";
                    break;
                case "NotEmpty":
                    error += fieldName+" can not be empty";
                    break;
                case "NotBlank":
                    error += fieldName+" can not be blank";
                    break;
                case "Min":
                    Object[] arguments = fieldError.getArguments();
                    if (arguments != null && arguments.length >= 1) {
                        long minValue = (Long) arguments[1];
                        error += fieldName + " must be at least " + minValue;
                    }
                    break;
                case "Max":
                    Object[] maxArguments = fieldError.getArguments();
                    if (maxArguments != null && maxArguments.length >= 2) {
                        long maxValue = (Long) maxArguments[1];
                        error += fieldName + " must not exceed " + maxValue;
                    }
                    break;
                case "Pattern":
                    error += fieldName + fieldError.getDefaultMessage();
                    break;
                case "Size":
                    Object[] sizeArguments = fieldError.getArguments();
                    if (sizeArguments != null && sizeArguments.length >= 3) {
                        int minSize = (Integer) sizeArguments[2];
                        int maxSize = (Integer) sizeArguments[1];
                        error += fieldName + " must be between " + minSize + " and " + maxSize + " characters long";
                    }
                    break;
                default:
                    error += fieldName + " has an invalid value";
                    break;
            }
            response.setMessage(error);
            response.setCode(ex.getBody().getStatus());
        }
        return response;
    }

}
