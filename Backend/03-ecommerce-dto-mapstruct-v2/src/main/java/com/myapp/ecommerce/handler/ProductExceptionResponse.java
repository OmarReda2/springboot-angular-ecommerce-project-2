package com.myapp.ecommerce.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductExceptionResponse {

    private int status;

    private String message;

    private long timeStamp;
}
