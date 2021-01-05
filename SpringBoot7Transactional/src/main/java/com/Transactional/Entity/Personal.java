package com.Transactional.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/26 16:44
 * @Package: com.Transactional.Entity
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
@Entity
public class Personal {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String detail;
    private Integer time;
    private String writer;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Personal(String name, String detail, Integer time, String writer) {
        this.name = name;
        this.detail = detail;
        this.time = time;
        this.writer = writer;
    }
}
