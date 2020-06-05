package com.moguding.batchedit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author admin
 */
@EnableScheduling
@SpringBootApplication
public class MoGuDingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoGuDingApplication.class, args);
    }

}
