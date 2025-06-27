CREATE OR REPLACE PROCEDURE TransferFunds (
    P_FromAccountId IN Accounts.AccountId%TYPE,
    P_ToAccountId IN Accounts.AccountId%TYPE,
    P_Amount IN number
) IS
    FromAccountBalance Accounts.Balance%TYPE;

    CURSOR AccountCursor IS
        SELECT
            AccountId,
            CustomerId,
            AccountType,
            Balance,
            LastModified
        FROM
            Accounts
        WHERE
            AccountId = P_FromAccountId
            OR AccountId = P_ToAccountId;

    AccountRecord AccountCursor%ROWTYPE;
BEGIN
    SELECT
        Balance
    INTO FromAccountBalance
    FROM
        Accounts
    WHERE
        AccountId = P_FromAccountId
    FOR UPDATE;

    IF FromAccountBalance < P_Amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
        RETURN;
    END IF;

    UPDATE Accounts
    SET
        Balance = Balance - P_Amount,
        LastModified = SYSDATE
    WHERE
        AccountId = P_FromAccountId;

    UPDATE Accounts
    SET
        Balance = Balance + P_Amount,
        LastModified = SYSDATE
    WHERE
        AccountId = P_ToAccountId;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
    DBMS_OUTPUT.PUT_LINE('Updated account details:');

    OPEN AccountCursor;
    LOOP
        FETCH AccountCursor INTO AccountRecord;
        EXIT WHEN AccountCursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('AccountID: '
                             || AccountRecord.AccountId
                             || ', CustomerID: '
                             || AccountRecord.CustomerId
                             || ', Type: '
                             || AccountRecord.AccountType
                             || ', Balance: $'
                             || TO_CHAR(AccountRecord.Balance, '999999.99')
                             || ', LastModified: '
                             || TO_CHAR(AccountRecord.LastModified, 'DD-MON-YYYY HH24:MI:SS'));
    END LOOP;
    CLOSE AccountCursor;

    DBMS_OUTPUT.PUT_LINE('');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed due to an error.');
END;

BEGIN
    TransferFunds(3, 1, 500);
    TransferFunds(3, 2, 40000);
END;
/