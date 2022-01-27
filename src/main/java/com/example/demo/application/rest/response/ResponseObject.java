package com.example.demo.application.rest.response;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class ResponseObject<T> {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    T data;
    String message;
}
