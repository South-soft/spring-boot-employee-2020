DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    age        INT          NOT NULL,
    gender     VARCHAR(10) DEFAULT NULL,
    company_id INT          Not NULL
);