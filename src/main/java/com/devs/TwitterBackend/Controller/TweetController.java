package com.devs.TwitterBackend.Controller;

import com.devs.TwitterBackend.Repository.JDBCTweetsRepository;
import com.devs.TwitterBackend.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@CrossOrigin
public class TweetController {

    @Autowired
    private final JDBCTweetsRepository repository;

    public TweetController(JDBCTweetsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<List<Tweet>> findAll(){
        System.out.println("Get tweets is returning " + repository.getTweets());
        return new ResponseEntity<>(repository.getTweets(), HttpStatus.ACCEPTED);
    }
}
