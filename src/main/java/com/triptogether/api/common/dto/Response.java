package com.triptogether.api.common.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true, builderMethodName = "responseBuilder")
public class Response {

    @Builder.Default
    private final String statusCode = "200";

    @Builder.Default
    private final String statusMessage = "Success";

    @Override
    public String toString() {
        return "Status code: " + statusCode + "\n" + "Status message: " + statusMessage;
    }
}

