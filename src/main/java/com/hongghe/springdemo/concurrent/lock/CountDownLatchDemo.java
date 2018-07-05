package com.hongghe.springdemo.concurrent.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static final Logger logger = LoggerFactory.getLogger(CountDownLatchDemo.class);

    private final CountDownLatch countDownLatch = new CountDownLatch(2);

    public void countDowmLatchProccess() {
        new Thread() {
            @Override
            public void run() {
                try {
                    logger.info("The sub process is running = {}", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    logger.error("The exception = {}", e);
                }
            };
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    logger.info("The sub process is running = {}", Thread.currentThread().getName());
                    Thread.sleep(100);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    logger.error("The exception = {}", e);
                }
            };
        }.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.info("Exception={}", e);
        }
    }
}
