CREATE TABLE Fresher (
    ID INT PRIMARY KEY,
    GraduationDate DATE,
    GraduationRank VARCHAR(50),
    Education VARCHAR(255),
    FOREIGN KEY (ID) REFERENCES Employee(ID)
);