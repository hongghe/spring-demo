package com.hongghe.springdemo.transaction;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class DemoTransaction {

    @Transactional
    public void selectUSerInfo(Long uid) throws Exception {
        try {
            Map<String, String> paramMap = new HashMap<>();
            while (paramMap != null) {
                //TODO
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
