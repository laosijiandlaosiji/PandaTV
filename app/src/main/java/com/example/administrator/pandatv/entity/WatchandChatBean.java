package com.example.administrator.pandatv.entity;

/**
 * Created by li on 2017/7/31.
 */

public class WatchandChatBean {

    private String author;
    private String message;
    private String total;
    private String tid;

    public WatchandChatBean() {
    }

    public WatchandChatBean(String author, String message, String total, String tid) {
        this.author = author;
        this.message = message;
        this.total = total;
        this.tid = tid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
