package com.devs.TwitterBackend.Repository;

import com.devs.TwitterBackend.model.Tweet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class JDBCTweetsRepository {

    private final JdbcTemplate jdbcTemplate;


    public JDBCTweetsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Tweet mapRow(ResultSet rs, int numRow) throws SQLException {
        return new Tweet(rs.getInt("tweet_id"),
                rs.getString("title"),
                rs.getString("username"),
                rs.getString("description"),
                rs.getTimestamp("date_created"));
    }

    public List<Tweet> getTweets() {
        String sql = "SELECT * FROM TWEETS";
        List<Tweet> tweets = jdbcTemplate.query(sql, JDBCTweetsRepository::mapRow);
        return tweets;
    }

    public void insertTweet(Tweet tweet)
    {
        String sql = "INSERT INTO TWEETS (username, title, description, date_created) VALUES (?, ?, ?, NOW())";
        jdbcTemplate.update(sql, tweet.username, tweet.title, tweet.description);
    }

    public void deleteTweet(Integer id)
    {
        String sql = "DELETE FROM TWEETS where tweet_id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void updateTweet(Tweet tweet)
    {
        String sql = "UPDATE TWEETS SET title=?, description=? ,date_created=NOW() WHERE tweet_id=? ";
        jdbcTemplate.update(sql, tweet.title, tweet.description, tweet.tweet_id);
    }
}
