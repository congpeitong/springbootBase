package com.example1.Demo;
/**
 * @Auther: MaleHunter
 * @Date: 2020/12/25 12:11
 * @Package: com.example.Demo
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot启动时会自动注入数据源和配置jpa
 * 解决：在@SpringBootApplication中排除其注入
 * @SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
 */

/**
 * 入口类中有一个main方法，这个main放在其实就是一个标准的Java 应用的入口方法，
 * 在mian方法中使用 SpringApplication.run(DemoApplication.class, args); 启动Spring Boot 项目。
 * 1, SpringBootConfiguration实际上就是@Configuration注解，表明这个类是一个配置类，
 * 2, EnableAutoConfiguration则表示让Spring Boot根据类路径中的jar包依赖为当前项目进行自动配置，
 * 3, ComponentScan的作用扫描带有注解controller/service....包，需要注意的是如果我们使用了@SpringBootApplication注解的话，
 *    系统会去入口类的同级包以及下级包中去扫描实体类，因此我们建议入口类的位置在groupId+arctifactID组合的包名下。
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
public class DemoApplication {

    //RequestMapping ,GetMapping是一个用来处理请求地址映射的注解，可用于类或方法上
    @GetMapping(value = "/hello",produces = "text/plain;charset=UTF-8")
    public String Test(){
        return "SpringBoot 第一个项目,在入口类中添加";
    }

    public static void main(String[] args) {
     //   SpringApplication.run(DemoApplication.class, args);//默认启动
        // 关闭Banner
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
        //修改Banner的模式为OFF
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}

