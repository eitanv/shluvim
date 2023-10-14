INSERT INTO INSTRUCTORS (INSTRUCTOR_ID, NAME, HOUR_SALARY)
                        VALUES (1001, 'Dan Cohen', 40);
INSERT INTO INSTRUCTORS (INSTRUCTOR_ID, NAME, HOUR_SALARY)
                        VALUES (1002, 'Yonit Shir', 50);

INSERT INTO  WORK_LOGS (END_WORK,LOG_DAY, LOG_MONTH, LOG_YEAR, START_WORK,INSTRUCTOR_ID, WORK_LOG_ID, INSTITUTE_ID)
VALUES ('14:30:00', 17,10,2023,'10:30:00', 1001, 100000, 10001);

INSERT INTO INSTITUTES (INSTITUTE_ID, INSTITUTE_NAME, INSTITUTE_TYPE, BASE_COST)
VALUES (10001, 'Keshet', 'School', 30);

INSERT INTO INSTITUTES (INSTITUTE_ID, INSTITUTE_NAME, INSTITUTE_TYPE, BASE_COST)
VALUES (10002, 'Gan Yore', 'Kindergarden', 20);