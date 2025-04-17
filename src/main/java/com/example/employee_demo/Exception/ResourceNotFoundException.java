package com.example.employee_demo.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResourceNotFoundException extends RuntimeException {

    private String message;
}
