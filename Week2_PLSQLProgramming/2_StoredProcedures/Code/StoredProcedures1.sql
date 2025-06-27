CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS

    CURSOR Cur IS
        SELECT
            AccountId,
            CustomerId,
            AccountType,
            Balance,
            LastModified
        FROM
            Accounts
        WHERE
            UPPER(AccountType) = 'SAVINGS';

    Acc Cur%ROWTYPE;
BEGIN
    UPDATE Accounts
    SET
        Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE
        UPPER(AccountType) = 'SAVINGS';

    COMMIT;

    OPEN Cur;
    LOOP
        FETCH Cur INTO Acc;
        EXIT WHEN Cur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('AccountID: '
                             || Acc.AccountId
                             || ', CustomerID: '
                             || Acc.CustomerId
                             || ', Balance: $'
                             || TO_CHAR(Acc.Balance, '999999.99')
                             || ', LastModified: '
                             || TO_CHAR(Acc.LastModified, 'DD-MON-YYYY HH24:MI:SS'));
    END LOOP;
    CLOSE Cur;

    DBMS_OUTPUT.PUT_LINE('Monthly interest successfully applied to Savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing interest: ' || SQLERRM);
END;

BEGIN
    ProcessMonthlyInterest;
END;
/