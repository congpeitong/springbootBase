package com.vueHeBing.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/29 11:28
 * @Package: com.vueHeBing.error
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {
  @Override
  public void registerErrorPages(ErrorPageRegistry registry) {
    ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
    registry.addErrorPages(error404Page);

  }
}
