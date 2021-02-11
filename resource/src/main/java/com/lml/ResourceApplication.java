package com.lml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ResourceApplication
 * @Description
 * @Author lml
 * @Date2021/2/2 15:09
 * @Version V1.0
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class);
    }
}
