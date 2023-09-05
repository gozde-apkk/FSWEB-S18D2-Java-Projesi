package com.workintech.restapi.FruitsVegetablesApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FruitErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}
