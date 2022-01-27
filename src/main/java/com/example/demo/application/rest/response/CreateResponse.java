package com.example.demo.application.rest.response;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class CreateResponse {

    String id;

}
