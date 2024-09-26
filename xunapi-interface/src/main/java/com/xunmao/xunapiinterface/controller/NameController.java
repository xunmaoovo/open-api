package com.xunmao.xunapiinterface.controller;

import com.xunmao.xunapiclientsdk.model.User;
import com.xunmao.xunapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 *
 * @author xunmao
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    /**
     * ？xx=xx格式接收参数
     *
     * @param name
     * @return
     */
    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    /**
     * json格式接收参数
     *
     * @param
     * @return
     */
    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际情况是去数据库中查 是否已分配给用户
        if(!accessKey.equals("xunmao")) {
            throw new RuntimeException("无权限");
        }
        // todo 校验随机数 这里简单校验一下
        if(Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // todo 校验时间戳 时间和当前时间不能超过一定值（比如五分钟

        // secretKey 就是服务端签发的，所以知道是什么
        // todo 实际情况是从数据库中 查出 secretKey
        // 根据accessKey 查到用户的那一整条数据，包含secretKey
        String serverSign = SignUtils.genSign(body, "abcdefgh");
        // 如果传递过来的sign 和后端生成的 sign不一致
        if(!sign.equals(serverSign)) {
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是" + user.getUsername();
    }

}
