package com.springboot.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 9:44
 * @Package: com.springboot.websocket
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Configuration
//开启使用STOMP协议来传输基于代理的消息，Broker就是代理。
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * registerStompEndpoints方法表示注册STOMP协议的节点，并映射指定的URL。
     * registry.addEndpoint("/endpoint").withSockJS();用来注册STOMP协议节点，并
     *   指定使用SockJS协议。
     *@param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint").withSockJS();

    }

    /**

     * configureMessageBroker方法用来配置消息代理，由于我们是广播式，这里的消息代理是/topic
     * @param registry
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");

    }
}
