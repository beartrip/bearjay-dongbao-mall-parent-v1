package com.edu.bearjay.dongbao.portal.web.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author langyixiong
 * @date 2021/5/14 17:07
 */
@Component
public class TestScheduled {
    @Scheduled(fixedDelay = 1000,initialDelay = 0)
    public void setIntervalTimeTask(){

        System.out.println("UUID: " + UUID.randomUUID().toString());
    }
}
