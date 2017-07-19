-- CREATE VIEW KONTA_START AS SELECT LOGIN,PASSWORD,ACCOUNT_FUNCTION FROM ACCOUNT WHERE ACTIVE=1;

DELETE FROM RENTIT.ACCOUNT;
-- DELETE FROM RENTIT.ACCOUNT_FUNCTION;
DELETE FROM RENTIT.EQUIPMENT;
-- DELETE FROM RENTIT.EQUIPMENT_STATUS;
DELETE FROM RENTIT.LICENSE_TYPE;
DELETE FROM RENTIT.RESERV;
DELETE FROM RENTIT.RESERV_STATUS;
DELETE FROM RENTIT.USE_PLACE;

INSERT INTO RENTIT.ACCOUNT (ID, ACCOUNT_FUNCTION, ACTIVE, EMAIL, LOGIN, NAME, PASSWORD, PHONE, SURNAME) 
VALUES (1, 'admin', 1, 'test@test.pl', 'admin', 'Przemysław', 'admin', '111111111', 'Przyslo');

INSERT INTO RENTIT.ACCOUNT (ID, ACCOUNT_FUNCTION, ACTIVE, EMAIL, LOGIN, NAME, PASSWORD, PHONE, SURNAME) 
VALUES (2, 'manager', 1, 'kierownik@kierownik.pl', 'manager', 'Jan', 'kierownik', '222222222', 'Tomaszak');

INSERT INTO RENTIT.ACCOUNT (ID, ACCOUNT_FUNCTION, ACTIVE, EMAIL, LOGIN, NAME, PASSWORD, PHONE, SURNAME) 
VALUES (3, 'employee', 1, 'pracownik@pracownik.pl', 'employee', 'Zenon', 'pracownik', '333333333', 'Pajor');

-- INSERT INTO RENTIT.ACCOUNT_FUNCTION (ID, FUNCTION_NAME, ACCOUNT_ID) 
-- VALUES (1, 'Administrator', 1);
-- 
-- INSERT INTO RENTIT.ACCOUNT_FUNCTION (ID, FUNCTION_NAME, ACCOUNT_ID) 
-- VALUES (2, 'Kierownik', 2);
-- 
-- INSERT INTO RENTIT.ACCOUNT_FUNCTION (ID, FUNCTION_NAME, ACCOUNT_ID) 
-- VALUES (3, 'Pracownik', 3);

-- INSERT INTO RENTIT.EQUIPMENT_STATUS (ID, EQUIPMENT_STATUS_NAME) 
-- VALUES (1, 'Sprawny');
-- 
-- INSERT INTO RENTIT.EQUIPMENT_STATUS (ID, EQUIPMENT_STATUS_NAME) 
-- VALUES (2, 'W naprawie');
-- 
-- INSERT INTO RENTIT.EQUIPMENT_STATUS (ID, EQUIPMENT_STATUS_NAME) 
-- VALUES (3, 'Niekompletny');
-- 
-- INSERT INTO RENTIT.EQUIPMENT_STATUS (ID, EQUIPMENT_STATUS_NAME) 
-- VALUES (4, 'Uszkodzony');

INSERT INTO RENTIT.USE_PLACE (ID, BUILDING, FLOOR, PLACE) 
VALUES (1, 'Budynek A', 1, 'sala208');

INSERT INTO RENTIT.USE_PLACE (ID, BUILDING, FLOOR, PLACE) 
VALUES (2, 'Budynek A', 1, 'sala201');

INSERT INTO RENTIT.USE_PLACE (ID, BUILDING, FLOOR, PLACE) 
VALUES (3, 'Budynek B', 0, 'sala516');

INSERT INTO RENTIT.LICENSE_TYPE (ID, LICENSE_END, LICENSE_NAME, LICENSE_SERIAL, LICENSE_START) 
VALUES (1, '2017-11-01', 'OEM', 'asdfg-qwert', '2015-11-01');

INSERT INTO RENTIT.LICENSE_TYPE (ID, LICENSE_END, LICENSE_NAME, LICENSE_SERIAL, LICENSE_START) 
VALUES (2, '2016-01-01', 'BOX', 'ghjkl-poi87', '2010-01-01');

INSERT INTO RENTIT.LICENSE_TYPE (ID, LICENSE_END, LICENSE_NAME, LICENSE_SERIAL, LICENSE_START) 
VALUES (3, '2017-06-15', 'Educational', 'zxcvb-12345', '2019-01-01');

INSERT INTO RENTIT.RESERV_STATUS (ID, RESERVATION_STATUS_NAME) 
VALUES (1, 'Zarezerwowany');

INSERT INTO RENTIT.RESERV_STATUS (ID, RESERVATION_STATUS_NAME) 
VALUES (2, 'Wypozyczony');

INSERT INTO RENTIT.RESERV_STATUS (ID, RESERVATION_STATUS_NAME) 
VALUES (3, 'Dostepny');

INSERT INTO RENTIT.EQUIPMENT (ID, NAME, RENT_PERMISSION, TYPE, LICENSE_TYPE_ID, USE_PLACE_ID) 
VALUES (1, 'Komputer', 1, 'stacjonarny',1, 1);

INSERT INTO RENTIT.EQUIPMENT (ID, NAME, RENT_PERMISSION, TYPE, LICENSE_TYPE_ID, USE_PLACE_ID) 
VALUES (2, 'Laptop1', 1, 'przenosny', 2, 2);

INSERT INTO RENTIT.EQUIPMENT (ID, NAME, RENT_PERMISSION, TYPE, LICENSE_TYPE_ID, USE_PLACE_ID) 
VALUES (3, 'Rzutnik', 0, 'stacjonarny', 2, 3);

INSERT INTO RENTIT.RESERV (ID, DESCRIPTION, RESERVATION_END, RESERVATION_MADE_DATE, RESERVATION_START, ACCOUNT_ID, EQUIPMENT_ID, RESERV_STATUS_ID) 
VALUES (1, 'Do celow szkoleniowych', '2017-09-01', '2017-06-01', '2017-07-01', 3, 1, 1);

INSERT INTO RENTIT.RESERV (ID, DESCRIPTION, RESERVATION_END, RESERVATION_MADE_DATE, RESERVATION_START, ACCOUNT_ID, EQUIPMENT_ID, RESERV_STATUS_ID) 
VALUES (2, 'Do celów prywatnych', '2017-12-01', '2017-06-15', '2017-07-15', 2, 2, 2);

INSERT INTO RENTIT.RESERV (ID, DESCRIPTION, RESERVATION_END, RESERVATION_MADE_DATE, RESERVATION_START, ACCOUNT_ID, EQUIPMENT_ID, RESERV_STATUS_ID) 
VALUES (3, 'Wyjazd sluzbowy', '2017-06-29', '2017-06-15', '2017-06-20', 1, 3, 1);


