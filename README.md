# 'My Lab Journal' 
Full stack backend application to analyze data and retrieve word frequency/similar words of a given input string based on the Levenshtein distance.

![Alt Text](https://github.com/iararoldan99/word-frequency-challenge/blob/main/word-frequency/word-frequency-page/word-frequency/public/images/gifs/chrome-capture-2022-6-25.gif)

Took 5 hours to complete. Had I had more time to complete it, I would have created a component for the @GetMapping 'getAll' endpoint to allow the user to see all the data entries, and I would have tested the backend service. I would also add EDIT and DELETE functionality. 

## FRONTEND Get Started (localhost:3000)

Requirements: Node.js and package manager NPM

### Install dependencies

```bash
npm install
```

### Start development server

```
npm run start
```

## BACKEND Get Started (localhost:8080)

Requirements: Java, Maven, MySQL database, preferred IDE: ECLIPSE/STS

### Run configurations

IMPORT AS 'Existing maven projects'

```bash
mvn i
Maven Build with goals: clean install 

Maven -> UPDATE PROJECT

Run as SpringBoot Application 
```

Please make sure you set up your database configuration (user, password and schema) in application.properties

### Create DATABASE SCHEMA (word-frequency) AND TABLE lab_entry

```
CREATE TABLE `lab_entry` (
  `id` int NOT NULL AUTO_INCREMENT,
  `researcher_name` varchar(145) DEFAULT NULL,
  `topic` varchar(145) DEFAULT NULL,
  `entry` longtext NOT NULL,
  `solicited_word` varchar(45) DEFAULT NULL,
  `word_frequency` int DEFAULT NULL,
  `similar_words` varchar(2045) DEFAULT 'No similar words found',
  PRIMARY KEY (`id`)
);



