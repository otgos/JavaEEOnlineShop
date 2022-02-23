package com.upper.entity;

import java.sql.Timestamp;

public class Comment {


    private Long id;
    private Client client;
    private String comments;
    private java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
    private Items item;



    public Comment(Long id, Client client, String comments, Timestamp date, Items item) {
        this.id = id;
        this.client = client;
        this.comments = comments;
        this.date = date;
        this.item = item;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }
}
