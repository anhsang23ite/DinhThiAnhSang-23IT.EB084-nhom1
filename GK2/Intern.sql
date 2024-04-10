CREATE TABLE Intern (
    ID INT PRIMARY KEY,
    Majors VARCHAR(255),
    Semester VARCHAR(20),
    UniversityName VARCHAR(255),
    FOREIGN KEY (ID) REFERENCES Employee(ID)
);