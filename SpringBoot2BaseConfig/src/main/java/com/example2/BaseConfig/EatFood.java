package com.example2.BaseConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "eat")
@PropertySource("classpath:eat.properties")//定位配置文件的位置
public class EatFood {
    private String eatName;
    private int eatprice;

    public String getEatName() {

        return eatName;
    }

    public void setEatName(String eatName) {

        this.eatName = eatName;
    }

    public int getEatprice() {

        return eatprice;
    }

    public void setEatprice(int eatprice) {

        this.eatprice = eatprice;
    }
}
