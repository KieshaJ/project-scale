package com.kj.articleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ArticleServiceApplication {
    protected Logger logger = Logger.getLogger(ArticleServiceApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

}
