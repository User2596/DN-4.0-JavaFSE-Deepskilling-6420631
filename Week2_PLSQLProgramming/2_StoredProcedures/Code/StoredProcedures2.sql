CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    P_Department IN Employees.Department%TYPE,
    P_BonusPercent IN number
) IS
    CURSOR EmpCur IS
        SELECT
            EmployeeId,
            Name,
            Salary
        FROM
            Employees
        WHERE
            UPPER(Department) = UPPER(P_Department);

    EmpRec EmpCur%ROWTYPE;
BEGIN
    UPDATE Employees
    SET
        Salary = Salary + (Salary * P_BonusPercent / 100)
    WHERE
        UPPER(Department) = UPPER(P_Department);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus of ' || P_BonusPercent || '% applied to department: ' || P_Department);

    OPEN EmpCur;
    LOOP
        FETCH EmpCur INTO EmpRec;
        EXIT WHEN EmpCur%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EmployeeID: ' || EmpRec.EmployeeId ||
                             ', Name: ' || EmpRec.Name ||
                             ', New Salary: $' || TO_CHAR(EmpRec.Salary, '999999.99'));
    END LOOP;
    CLOSE EmpCur;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error applying bonus: ' || SQLERRM);
END;

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/