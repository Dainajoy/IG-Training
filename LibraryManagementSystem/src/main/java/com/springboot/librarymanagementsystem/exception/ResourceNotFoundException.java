package com.springboot.librarymanagementsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;
    private String resourceName;
    private String fieldName;
    private long fieldValue;
    public ResourceNotFoundException(String message) {
        super(message);
    }

}