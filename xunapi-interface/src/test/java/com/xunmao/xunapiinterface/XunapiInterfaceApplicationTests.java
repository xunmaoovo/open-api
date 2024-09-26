package com.xunmao.xunapiinterface;

import com.xunmao.xunapiclientsdk.client.XunApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XunapiInterfaceApplicationTests {

    @Resource
    private XunApiClient xunApiClient;

    @Test
    void contextLoads() {
        String xunmao = xunApiClient.getNameByPost("xunmao");

    }

}
