package com.Chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import java.security.Principal;
import org.springframework.stereotype.Controller;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 14:44
 * @Package: com.Chat.controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Controller
public class WsController {
    /**
     * 1. SimpMessagingTemplate 引入这个类主要是实现向浏览器发送消息
     * 2. 在spring mvc中，可以直接在参数中获得principal，这里面包含当前用户的信息
     * 3. 通过messageingTemplate.convertAndSendToUser 向用户发送消息，参数1 是接收消息的用户，
     *    参数2是浏览器订阅的地址，参数3是消息内容
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if(principal.getName().equals("andy")){
            simpMessagingTemplate.convertAndSendToUser("chen", "/queue/notifications",principal.getName() + "给您发来了消息：" + msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("andy", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }

    }
}
