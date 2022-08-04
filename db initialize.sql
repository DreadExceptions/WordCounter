-- written for sqlite
-- database table initialization

CREATE TABLE word (
    wordID INTEGER PRIMARY KEY,
    letters TEXT UNIQUE,
    trueSyllables INTEGER,
    estSyllables INTEGER
);

CREATE TABLE document (
    documentID INTEGER PRIMARY KEY,
    fileName TEXT,
    filePath TEXT,
    lastUpdated DATE,
    UNIQUE (fileName, filePath)
);

CREATE TABLE wordCount (
    documentID INTEGER,
    wordID INTEGER,
    count INTEGER,
    PRIMARY KEY (documentID, wordID),
    FOREIGN KEY (documentID) REFERENCES document(documentID),
    FOREIGN KEY (wordID) REFERENCES word(wordID)
);

CREATE TABLE commonWords (
    rankID INTEGER PRIMARY KEY,
    wordID INTEGER UNIQUE,
    FOREIGN KEY (wordID) REFERENCES word(wordID)
);