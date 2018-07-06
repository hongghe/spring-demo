package com.hongghe.springdemo.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The person parent class
 *
 * @author hongghe
 */
public class SuperMan extends Person {
    private static final Logger logger = LoggerFactory.getLogger(SuperMan.class);
    public void fly() {
        logger.info("I believe I can fly.");
    }
}
