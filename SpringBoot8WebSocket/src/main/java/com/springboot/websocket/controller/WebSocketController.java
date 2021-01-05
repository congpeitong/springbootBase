package com.springboot.websocket.controller;

import com.springboot.websocket.Message.RequestMessage;
import com.springboot.websocket.Message.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 9:56
 * @Package: com.springboot.websocket.controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Controller
public class WebSocketController {
    /**
     * 1.当浏览器向服务器发请求的时候，通过@MessageMapping 映射/welcome这个地址，类似于@RequestMapping
     * 2. @SendTo注解表示当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息。
     * @param message
     * @return
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message){
        System.out.println(message.getName());
        ResponseMessage responseMessage = new ResponseMessage("welcom," + message.getName() + "!");
        return responseMessage;
    }
}
