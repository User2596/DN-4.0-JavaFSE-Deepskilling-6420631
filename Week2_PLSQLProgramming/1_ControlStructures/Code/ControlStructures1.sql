DECLARE
    CURSOR CustCur IS
        SELECT
            C.CustomerId,
            C.Name,
            C.Dob,
            L.LoanId,
            L.LoanAmount,
            L.InterestRate
        FROM
            Customers C
            JOIN Loans L ON L.CustomerId = C.CustomerId;

    Age number;
    NewInterest Loans.InterestRate%TYPE;
BEGIN
    FOR Cust IN CustCur LOOP
        Age := CEIL(MONTHS_BETWEEN(SYSDATE, Cust.Dob) / 12);
        IF Age > 60 THEN
            NewInterest := Cust.InterestRate - 1;
            IF NewInterest < 0 THEN
                NewInterest := 0;
            END IF;
            UPDATE Loans
            SET InterestRate = NewInterest
            WHERE LoanId = Cust.LoanId;

            DBMS_OUTPUT.PUT_LINE('Customer ID: '
                                 || Cust.CustomerId
                                 || ' - Age: '
                                 || Age
                                 || ' - Interest rate reduced from '
                                 || Cust.InterestRate
                                 || '% to '
                                 || NewInterest
                                 || '%');

        ELSE
            DBMS_OUTPUT.PUT_LINE('Customer ID: '
                                 || Cust.CustomerId
                                 || ' - Age: '
                                 || Age
                                 || ' - Not eligible for discount');
        END IF;

    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Changes Successful');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/