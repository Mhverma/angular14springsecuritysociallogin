package com.manoj.springsecurity.dto;

import lombok.Data;
import lombok.Value;

@Value
public class ApiResponse {
    private Boolean status;
    private String message;
}
