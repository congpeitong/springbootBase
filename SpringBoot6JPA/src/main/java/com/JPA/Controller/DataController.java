package com.JPA.Controller;

import com.JPA.Entity.Person;
import com.JPA.Interface.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:06
 * @Package: com.JPA.Controller
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age) {
        Person persons = new Person();
        persons.setName(name);
        persons.setAddress(address);
        persons.setAge(age);
        Person person = personRepository.save(persons);
        return person;
    }

    @RequestMapping("/findByaddress")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/findBynameAndaddress")
    public Person q2(String name, String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }
    //    @RequestMapping("/sort")
//    public List<Person> sort() {
//        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
//        return people;
//    }
    @RequestMapping("/page")
    public Page<Person> page(int page, int size){
        Page<Person> all = personRepository.findAll(PageRequest.of(page, size));
        return all;
    }
    @RequestMapping("/all")
    public List<Person> all(){
        return personRepository.findAll();
    }
}
