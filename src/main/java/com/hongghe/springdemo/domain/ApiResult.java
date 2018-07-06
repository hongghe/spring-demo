package com.hongghe.springdemo.domain;

import lombok.Data;

@Data
public class ApiResult {
    public Integer code;
    public String message;
    public Object data;
}
