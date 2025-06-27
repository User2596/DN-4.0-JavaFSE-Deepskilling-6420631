SET DEFINE OFF;

CREATE TABLE Customers (
    CustomerId number PRIMARY KEY,
    Name varchar2(100),
    Dob date,
    Balance number,
    LastModified date
);

CREATE TABLE Accounts (
    AccountId number PRIMARY KEY,
    CustomerId number,
    AccountType varchar2(20),
    Balance number,
    LastModified date,
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId)
);

CREATE TABLE Transactions (
    TransactionId number PRIMARY KEY,
    AccountId number,
    TransactionDate date,
    Amount number,
    TransactionType varchar2(10),
    FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)
);

CREATE TABLE Loans (
    LoanId number PRIMARY KEY,
    CustomerId number,
    LoanAmount number,
    InterestRate number,
    StartDate date,
    EndDate date,
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId)
);

CREATE TABLE Employees (
    EmployeeId number PRIMARY KEY,
    Name varchar2(100),
    Position varchar2(50),
    Salary number,
    Department varchar2(50),
    HireDate date
);

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans (LoanId, CustomerId, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (3, 'Emily Davis', TO_DATE('1988-09-10', 'YYYY-MM-DD'), 11000, SYSDATE);

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (4, 'Michael Green', TO_DATE('1964-12-05', 'YYYY-MM-DD'), 2500, SYSDATE);

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (5, 'Laura Adams', TO_DATE('1975-04-22', 'YYYY-MM-DD'), 3200, SYSDATE);

INSERT INTO Customers (CustomerId, Name, Dob, Balance, LastModified)
VALUES (6, 'Steven Clark', TO_DATE('1995-10-08', 'YYYY-MM-DD'), 8700, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 11000, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (4, 4, 'Checking', 2500, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (5, 5, 'Savings', 3200, SYSDATE);

INSERT INTO Accounts (AccountId, CustomerId, AccountType, Balance, LastModified)
VALUES (6, 6, 'Checking', 8700, SYSDATE);

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (3, 3, SYSDATE, 500, 'Deposit');

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (4, 4, SYSDATE, 700, 'Withdrawal');

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (5, 5, SYSDATE, 600, 'Deposit');

INSERT INTO Transactions (TransactionId, AccountId, TransactionDate, Amount, TransactionType)
VALUES (6, 6, SYSDATE, 400, 'Withdrawal');

INSERT INTO Loans (LoanId, CustomerId, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 4.5, TO_DATE('2021-07-20', 'YYYY-MM-DD'), ADD_MONTHS(TO_DATE('2021-07-20', 'YYYY-MM-DD'), 48));

INSERT INTO Loans (LoanId, CustomerId, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 4, 8000, 6, TO_DATE('2024-06-30', 'YYYY-MM-DD'), ADD_MONTHS(TO_DATE('2024-06-30', 'YYYY-MM-DD'), 12));

INSERT INTO Loans (LoanId, CustomerId, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (4, 5, 7000, 5.5, TO_DATE('2023-03-01', 'YYYY-MM-DD'), ADD_MONTHS(TO_DATE('2023-03-01', 'YYYY-MM-DD'), 36));

INSERT INTO Loans (LoanId, CustomerId, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (5, 6, 9500, 4.2, TO_DATE('2022-12-15', 'YYYY-MM-DD'), ADD_MONTHS(TO_DATE('2022-12-15', 'YYYY-MM-DD'), 60));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (3, 'Carol White', 'Analyst', 50000, 'Finance', TO_DATE('2018-11-01', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (4, 'David King', 'Support', 45000, 'Customer Service', TO_DATE('2020-02-10', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (5, 'Eva Moore', 'Consultant', 65000, 'Operations', TO_DATE('2019-05-10', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeId, Name, Position, Salary, Department, HireDate)
VALUES (6, 'Frank Lee', 'Engineer', 58000, 'R&D', TO_DATE('2021-01-18', 'YYYY-MM-DD'));