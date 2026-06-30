SHOW DATABASES;
use bankdb;

UPDATE Loans l
JOIN Customers c
ON l.CustomerID = c.CustomerID
SET l.InterestRate = l.InterestRate - 1
WHERE c.Age > 60;

SELECT c.CustomerID,
       c.Name,
       c.Age,
       l.InterestRate
FROM Customers c
JOIN Loans l
ON c.CustomerID = l.CustomerID;

SHOW TABLES;

use bankdb;
UPDATE Customers
SET IsVIP = TRUE
WHERE Balance > 10000;

SET SQL_SAFE_UPDATES = 0;

UPDATE Customers
SET IsVIP = TRUE
WHERE Balance > 10000;

SELECT CustomerID,
       Name,
       Balance,
       IsVIP
FROM Customers;


DELIMITER //

CREATE PROCEDURE LoanReminder()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE c_name VARCHAR(100);
    DECLARE due_date DATE;

    DECLARE cur CURSOR FOR
        SELECT c.Name, l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;

    read_loop: LOOP
        FETCH cur INTO c_name, due_date;

        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT('Reminder: ', c_name,
                      ', your loan is due on ',
                      due_date) AS Message;
    END LOOP;

    CLOSE cur;
END //

DELIMITER ;

