package com.example4.webThymleaf;

import com.example4.webThymleaf.Bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/25 21:22
 * @Package: com.example4.webThymleaf
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@SpringBootApplication
@Controller
public class SpringBoot4Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot4Application.class, args);
    }
    @RequestMapping("/")
    public String index(Model model) {
        Person single = new Person();
        single.setName("MaleHunters");
        single.setAge(23);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("刘德华");
        p1.setAge(60);
        Person p2 = new Person();
        p2.setName("张学友");
        p2.setAge(58);
        Person p3 = new Person();
        p3.setName("周润发");
        p3.setAge(58);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }
}
