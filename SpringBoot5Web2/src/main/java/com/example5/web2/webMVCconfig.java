package com.example5.web2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/25 21:59
 * @Package: com.example5.web2
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Configuration
//@EnableWebMvc无需使用该注解，否则会覆盖掉SpringBoot的默认配置值
/**
 * WebMvcConfigurerAdapter常用的方法
 * ··1. addInterceptors: 拦截器
 * ··2. addCorsMapping: 跨域
 * ··3. addViewControllers: 指定页面跳转
 * ··4. resourceViewResolver: 试图解析器
 * ··5. configureMessageConverters: 信息转换器
 * ··6. addResourceHandlers: 静态资源
 * WebMvcConfigureAdapter使用方式：
 *   1.继承WebMvcConfigurerAdapter(过时)
 *   2.实现WebMvcConfigurer
 *   3.继承WebMvcConfigurationSupport
 */
public class webMVCconfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
    }
}
