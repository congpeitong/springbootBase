package com.vueHeBing.config;

import com.vueHeBing.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/1 10:31
 * @Package: com.vueHeBing.config
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
//配置拦截器使其生效
  @SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {
  @Bean
  public LoginInterceptor getLoginInterceptor() {
    return new LoginInterceptor();
  }
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //此拦截器对所有路径的应用进行了拦截，除去 /index.html(vue-cli的入口)
    registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html");

  }
}
