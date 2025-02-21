CREATE DATABASE IF NOT EXISTS quotes;
USE quotes;

CREATE TABLE IF NOT EXISTS quote (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL
);

INSERT INTO quote (text) VALUES ("The only limit to our realization of tomorrow is our doubts of today.");
INSERT INTO quote (text) VALUES ("The purpose of our lives is to be happy.");
INSERT INTO quote (text) VALUES ("Life is what happens when you're busy making other plans.");
INSERT INTO quote (text) VALUES ("Get busy living or get busy dying.");
INSERT INTO quote (text) VALUES ("You have within you right now, everything you need to deal with whatever the world can throw at you.");
INSERT INTO quote (text) VALUES ("Believe you can and you're halfway there.");
INSERT INTO quote (text) VALUES ("The only impossible journey is the one you never begin.");
INSERT INTO quote (text) VALUES ("Life is short, and it is up to you to make it sweet.");
INSERT INTO quote (text) VALUES ("The purpose of life is not to be happy. It is to be useful, to be honorable, to be compassionate, to have it make some difference that you have lived and lived well.");
INSERT INTO quote (text) VALUES ("In the end, it's not the years in your life that count. It's the life in your years.");

CREATE TABLE IF NOT EXISTS message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    text VARCHAR(255) NOT NULL,

    quote VARCHAR(255) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);