package com.xunmao.xunapiinterface;

import com.xunmao.xunapiclientsdk.client.XunApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(XunApiClient.class)
public class XunapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunapiInterfaceApplication.class, args);
    }

}
