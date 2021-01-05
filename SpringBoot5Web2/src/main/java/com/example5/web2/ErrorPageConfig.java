package com.example5.web2;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/25 22:11
 * @Package: com.example5.web2
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Component
/**
 * 自定义类实现
 * ErrorPageRegistrar接口，然后设置端口、设置错误请求页面、
 * 设置会话超时时间等，这里的404页面放在src/main/resources/static文件夹下，
 * 有了这个之后，当我访问一个不存在的页面的时候就会跳转到404.html页面了。
 */
public class ErrorPageConfig implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page=new ErrorPage(HttpStatus.BAD_REQUEST,"/error400.html" );
        ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/error401.html");
        ErrorPage error404Page=new ErrorPage(HttpStatus.NOT_FOUND,"/404.html" );  //找不到网页
        ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error500.html");//服务器响应错误
        registry.addErrorPages(error400Page,error401Page,error404Page,error500Page);
    }
}
