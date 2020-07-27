package com.central.medicare;

import com.central.common.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yuan.zk
 */
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableFeignInterceptor
@SpringBootApplication
public class MedicareCenterApp {
    public static void main(String[] args) {
        SpringApplication.run(MedicareCenterApp.class, args);
    }
}
