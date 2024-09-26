package com.xunmao.xunapiclientsdk;

import com.xunmao.xunapiclientsdk.client.XunApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("xunapi.client")
@Data
@ComponentScan
public class XunApiClientConfig {
    private String accessKey;

    private String secretKey;

    @Bean
    public XunApiClient xunApiClient(){
        return new XunApiClient(accessKey, secretKey);
    }

}
