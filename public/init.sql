CREATE TABLE USERS
(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255),
    email    VARCHAR(255)
);

CREATE TABLE TWEETS
(
    tweet_id     SERIAL PRIMARY KEY,
    username     VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    title        VARCHAR(255) NOT NULL,
    description  VARCHAR(255),
    date_created TIMESTAMP

);

CREATE TABLE FOLLOWS
(
    follower VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    followee VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    PRIMARY KEY (follower, followee)

);

CREATE TABLE RETWEETS
(
    username VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    tweet_id INT REFERENCES TWEETS (tweet_id) ON DELETE CASCADE,
    PRIMARY KEY (username, tweet_id)
);


CREATE TABLE EXPLORE
(
    username VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    tweet_id INT REFERENCES TWEETS (tweet_id) ON DELETE CASCADE,
    PRIMARY KEY (username, tweet_id)
);


CREATE TABLE LIKED
(
    username VARCHAR(255) REFERENCES USERS (username) ON DELETE CASCADE,
    tweet_id INT REFERENCES TWEETS (tweet_id) ON DELETE CASCADE,
    PRIMARY KEY (username, tweet_id)
);

