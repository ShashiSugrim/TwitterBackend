-- Insert data into USERS table
INSERT INTO USERS (username, password, email)
VALUES ('user1', 'password123', 'user1@example.com');

INSERT INTO USERS (username, password, email)
VALUES ('user2', 'secret456', 'user2@example.com');

-- Insert data into TWEETS table
INSERT INTO TWEETS (username, title, description, date_created)
VALUES ('user1', 'First tweet', 'This is my first tweet.', '2023-09-13 10:00:00');

INSERT INTO TWEETS (username, title, description, date_created)
VALUES ('user2', 'Hello world', 'Just saying hello to the world.', '2023-09-13 10:15:00');

-- Insert data into FOLLOWS table
INSERT INTO FOLLOWS (follower, followee)
VALUES ('user1', 'user2');

INSERT INTO FOLLOWS (follower, followee)
VALUES ('user2', 'user1');

-- Insert data into RETWEETS table
INSERT INTO RETWEETS (username, tweet_id)
VALUES ('user1', 1);

INSERT INTO RETWEETS (username, tweet_id)
VALUES ('user2', 2);

-- Insert data into EXPLORE table
INSERT INTO EXPLORE (username, tweet_id)
VALUES ('user1', 2);

INSERT INTO EXPLORE (username, tweet_id)
VALUES ('user2', 1);

-- Insert data into LIKED table
INSERT INTO LIKED (username, tweet_id)
VALUES ('user1', 2);

INSERT INTO LIKED (username, tweet_id)
VALUES ('user2', 1);
