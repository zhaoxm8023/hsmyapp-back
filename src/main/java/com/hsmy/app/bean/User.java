package com.hsmy.app.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * userRepository操作的bean
 */
@Data
@Getter
@Setter
@Document(indexName = "hsmy")
public class User implements Serializable {
    @Id
    private Integer id;
    private String name;

    private String address;
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}

/**
 *
 * Jest操作的bean
     @Data
     public class User {
     @JestId
     private Integer id;
     private String name;
     private String address;
     private Integer sex;
     }

 */