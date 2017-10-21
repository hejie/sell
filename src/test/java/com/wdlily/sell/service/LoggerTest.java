package com.wdlily.sell.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private Logger logger = LoggerFactory.getLogger(LoggerTest.class);

//    @Test
//    public void loggerTest(){
//        logger.debug("debug...");
//        logger.info("info...");
//        logger.error("error...");
//    }
    @Test
    public void loggerTest2(){
        log.debug("debug...");
        log.info("info...");
        log.error("error...");

        String username = "lily";
        String password = "wd";
        log.error("username:{},password:{}",username,password);
    }
}
