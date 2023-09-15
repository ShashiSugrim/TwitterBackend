package com.devs.TwitterBackend.Controller;

import com.devs.TwitterBackend.Repository.JDBCTweetsRepository;
import com.devs.TwitterBackend.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public void createTweet(@RequestBody Tweet tweet)
    {
        System.out.println("This is tweet received " + tweet);
        repository.insertTweet(tweet);
    }

    // to delete, send a request to postman, raw data, only an integer
    @DeleteMapping("")
    public void deleteTweet(@RequestBody Integer id)
    {
        System.out.println("We are receiving request to delete with id " + id);
        repository.deleteTweet(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public void updateTweet(@RequestBody Tweet tweet)
    {
        repository.updateTweet(tweet);
    }
}
