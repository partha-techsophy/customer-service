package com.example.demo.execption;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.Instant;

/**
 * Error object returned to client. This message can be customised as required by your project
 * Sample response
 * {
 * "timestamp": "2020-06-15T09:27:33.206Z",
 * "message": "User with id 20 not found!",
 * "details": "uri=/api/1.0.0/users/20"
 * }
 */

/**
 * Lombok annotation
 */
@Value
@RequiredArgsConstructor
public class ErrorDetails {
    /**
     * ISO date format
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    Instant timestamp;
    String error;
    String message;
    int status;
}
