package com.example.dust;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：guodongzhang
 * @date ：Created in 2021/5/20 20:56
 */
@SpringBootApplication
public class DustApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DustApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run(args);
    }
}
