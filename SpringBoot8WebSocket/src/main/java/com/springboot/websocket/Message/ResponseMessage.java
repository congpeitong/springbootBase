package com.springboot.websocket.Message;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 9:52
 * @Package: com.springboot.websocket.Message
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
//服务器向浏览器返回消息
public class ResponseMessage {
    private String responseMessage;

    public String getResponseMessage() {

        return responseMessage;
    }


    public ResponseMessage(String responseMessage) {

        this.responseMessage = responseMessage;
    }
}
