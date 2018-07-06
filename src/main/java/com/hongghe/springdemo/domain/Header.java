package com.hongghe.springdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    public String uuid;
    public Long uid;
    public String remoteIp;
}
