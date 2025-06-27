DECLARE
    CURSOR LoanCur IS
        SELECT
            L.LoanId,
            L.CustomerId,
            L.LoanAmount,
            L.EndDate,
            C.Name
        FROM
            Loans L
            JOIN Customers C ON L.CustomerId = C.CustomerId
        WHERE
            L.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR LoanDue IN LoanCur LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear '
                             || LoanDue.Name
                             || ', your loan (ID: '
                             || LoanDue.LoanId
                             || ') of amount $'
                             || LoanDue.LoanAmount
                             || ' is due on '
                             || TO_CHAR(LoanDue.EndDate, 'DD-MON-YYYY')
                             || '. Please ensure timely repayment.');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('All Reminders Successfully Sent');
END;
/