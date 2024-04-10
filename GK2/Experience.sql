CREATE TABLE Experience (
    ID INT PRIMARY KEY,
    ExpInYear INT,
    ProSkill VARCHAR(255),
    FOREIGN KEY (ID) REFERENCES Employee(ID)
);