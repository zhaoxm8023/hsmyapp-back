package com.hsmy.app.bean;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Getter
@Setter
@Document(indexName = "docu")
public class HsmyInfoSearch {

    @Id
    private String id;
    private String author;
    private String title;
    private String content;
    private Date time;


    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getTime() {
        return time;
    }
}
