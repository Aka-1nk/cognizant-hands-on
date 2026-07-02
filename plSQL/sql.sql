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

CALL LoanReminder();

Select * from loans


ALTER TABLE Loans
ADD COLUMN DueDate DATE;

SET SQL_SAFE_UPDATES = 0;
UPDATE Loans
SET DueDate = CASE LoanID
    WHEN 1 THEN DATE_ADD(CURDATE(), INTERVAL 5 DAY)
    WHEN 2 THEN DATE_ADD(CURDATE(), INTERVAL 15 DAY)
    WHEN 3 THEN DATE_ADD(CURDATE(), INTERVAL 25 DAY)
    WHEN 4 THEN DATE_ADD(CURDATE(), INTERVAL 40 DAY)
    WHEN 5 THEN DATE_ADD(CURDATE(), INTERVAL 60 DAY)
    ELSE DATE_ADD(CURDATE(), INTERVAL 20 DAY)
END;

CALL LoanReminder();



DELIMITER //

CREATE PROCEDURE SafeTransferFunds(
    IN p_from INT,
    IN p_to INT,
    IN p_amount DECIMAL(10,2)
)
BEGIN
    DECLARE balance DECIMAL(10,2);

    START TRANSACTION;

    SELECT Balance
    INTO balance
    FROM Accounts
    WHERE AccountID = p_from;

    IF balance < p_amount THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient Funds';
    ELSE
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to;

        COMMIT;
    END IF;
END //

DELIMITER ;

CALL SafeTransferFunds(1, 2, 500);

DELIMITER //

CREATE PROCEDURE UpdateSalary(
    IN emp_id INT,
    IN percent_inc DECIMAL(5,2)
)
BEGIN
    IF EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = emp_id) THEN

        UPDATE Employees
        SET Salary = Salary + (Salary * percent_inc / 100)
        WHERE EmployeeID = emp_id;

    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Employee Not Found';
    END IF;
END //

DELIMITER ;

CALL UpdateSalary(101, 10);

select * from employees


CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_emp_id IN NUMBER,
    p_percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('ERROR: Employee Not Found');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected Error Occurred');
END;


DELIMITER //

CREATE PROCEDURE AddNewCustomer(
    IN cid INT,
    IN cname VARCHAR(100),
    IN balance DECIMAL(10,2)
)
BEGIN

    IF EXISTS (SELECT 1 FROM Customers WHERE CustomerID = cid) THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT='Customer already exists';

    ELSE

        INSERT INTO Customers(CustomerID,Name,Balance)
        VALUES(cid,cname,balance);

    END IF;

END //

DELIMITER ;

CALL AddNewCustomer(201, 'Ravi', 8000);


DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END //

DELIMITER ;

CALL ProcessMonthlyInterest();
Select * from Accounts;


DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept VARCHAR(50),
    IN bonus DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus / 100)
    WHERE Department = dept;
END //

DELIMITER ;

CALL UpdateEmployeeBonus('IT', 5);
Select * from employees;

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN fromAcc INT,
    IN toAcc INT,
    IN amt DECIMAL(10,2)
)
BEGIN
    DECLARE bal DECIMAL(10,2);

    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = fromAcc;

    IF bal >= amt THEN
        UPDATE Accounts SET Balance = Balance - amt WHERE AccountID = fromAcc;
        UPDATE Accounts SET Balance = Balance + amt WHERE AccountID = toAcc;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient Balance';
    END IF;
END //

DELIMITER ;

CALL TransferFunds(1, 2, 1000);



DELIMITER //

CREATE PROCEDURE UpdateSalary(
    IN emp_id INT,
    IN percent_inc DECIMAL(5,2)
)
BEGIN
    IF EXISTS (SELECT 1 FROM Employees WHERE EmployeeID = emp_id) THEN

        UPDATE Employees
        SET Salary = Salary + (Salary * percent_inc / 100)
        WHERE EmployeeID = emp_id;

    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Employee Not Found';
    END IF;
END //

DELIMITER ;

CALL UpdateSalary(101, 10);