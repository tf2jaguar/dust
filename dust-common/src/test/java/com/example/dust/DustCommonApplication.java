package com.example.dust;

import com.gxjiaotong.micro.codec.codec.FeignClientDecoder;
import com.gxjiaotong.micro.codec.codec.FeignClientEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：zhang guo dong
 * @date ：Created in 2021/2/4 下午7:22
 */

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.dust.service.third"}, defaultConfiguration = {FeignClientEncoder.class, FeignClientDecoder.class})
public class DustCommonApplication {
    public static void main(String[] args) {
        SpringApplication.run(DustCommonApplication.class, args);
    }
}
