package com.JPA.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 15:57
 * @Package: com.JPA.Entity
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Entity//表示这是一个数据库表映射的实体类
//@NamedQuery注解表示一个NamedQuery查询，这里一个名称代表一个查询语句
@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
            query = "select p from Person p where p.name=?1 and p.address=?2")
public class Person {
    @Id  //表示该字段是一个id
    @GeneratedValue  //表示该字段自增
    private Long id;
    private String name;
    private Integer age;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(Long id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }
}
