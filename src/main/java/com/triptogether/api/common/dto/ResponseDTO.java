package com.triptogether.api.common.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder(toBuilder = true, builderMethodName = "responseBuilder")
public class ResponseDTO<T> {

    @Builder.Default
    private final String statusCode = "200";

    @Builder.Default
    private final String statusMessage = "Success";

    private T data;

    private Map<String,String> errors;

    @Override
    public String toString() {
        return "Status code: " + statusCode + "\n" + "Status message: " + statusMessage;
    }
}

