SELECT p.NAME,
       EXTRACT(MONTH FROM AGE(p.FINISH_DATE, p.START_DATE)) AS MONTH_COUNT
FROM project p
WHERE EXTRACT(MONTH FROM AGE(p.FINISH_DATE, p.START_DATE)) = (
    SELECT MAX(EXTRACT(MONTH FROM AGE(FINISH_DATE, START_DATE)))
    FROM project
);