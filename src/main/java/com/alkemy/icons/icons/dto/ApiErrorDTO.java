package com.alkemy.icons.icons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.util.*;

@Data
@AllArgsConstructor
public class ApiErrorDTO {
    private HttpStatus httpStatus;
    private String message;
    private List<String> errors;
}
