ALTER TABLE Customers ADD IsVip BOOLEAN DEFAULT FALSE;

DECLARE
    CURSOR CustCur IS
        SELECT
            CustomerId,
            Name,
            Balance
        FROM
            Customers;

    UpdatedCount number := 0;
BEGIN
    FOR Cust IN CustCur LOOP
        IF Cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVip = TRUE
            WHERE CustomerId = Cust.CustomerId;

            DBMS_OUTPUT.PUT_LINE(Cust.Name
                                 || ' (ID: '
                                 || Cust.CustomerId
                                 || ') got promoted');

            UpdatedCount := UpdatedCount + 1;
        END IF;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(UpdatedCount || ' customers promoted to VIP.');
END;
/