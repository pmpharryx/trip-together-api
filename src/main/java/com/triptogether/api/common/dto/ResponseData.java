package com.triptogether.api.common.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true, builderMethodName = "responseDataBuilder")
public class ResponseData<T> extends Response{

    private T data;

    @Override
    public String toString() {
        return super.toString() + "\n" + "Data: " + (data != null ? data.toString() : "null");
    }
}

