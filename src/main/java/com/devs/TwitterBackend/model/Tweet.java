package com.devs.TwitterBackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Table(name="tweets")
public class Tweet {
    @Id
    public Integer tweet_id;

    public String title;

    public String username;

    public String description;

    public Timestamp date_created;

    public Tweet(Integer tweet_id, String title, String username, String description, Timestamp date_created)
    {
        this.tweet_id = tweet_id;
        this.title = title;
        this.username = username;
        this.description = description;
        this.date_created = date_created;
    }

    @Override
    public String toString(){
        return "Title " + title + ". Description: " + description + ".Username" + username + ".Timestamp: " + date_created;
    }
}
