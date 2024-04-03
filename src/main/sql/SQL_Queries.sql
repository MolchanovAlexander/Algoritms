/*distinct */
SELECT distinct age
FROM people
/*  */
SELECT CASE
           WHEN SUM(x) % 2 = 0 THEN MAX(x)
           ELSE MIN(x)
           END AS x,
       CASE
           WHEN SUM(y) % 2 = 0 THEN MAX(y)
           ELSE MIN(y)
           END AS y,
       CASE
           WHEN SUM(z) % 2 = 0 THEN MAX(z)
           ELSE MIN(z)
           END AS z
FROM numbers;
/* 783786306-2 перетворюється на XX3XXX30X-2 */
select name,
       price,
       REPLACE(
               REPLACE(
                       REPLACE(
                               REPLACE(
                                       REPLACE(isbn, '5', 'X'), '6', 'X'), '7', 'X'), '8', 'X'), '9', 'X')
           AS isbn
FROM devices

/* the same */
SELECT name, price, TRANSLATE(isbn, '56789', 'XXXXX') AS isbn
FROM devices;
/*  2 equal solutions below*/
SELECT
    CASE
        WHEN (x * (y + z)) > (x * y * z)
            and (x * (y + z)) > (x + y * z)
            and (x * (y + z)) > ((x + y) * z) THEN (x * (y + z))
        WHEN (x * y * z) > (x * (y + z))
            and (x * y * z) > (x + y * z)
            and (x * y * z) > ((x + y) * z) THEN (x * y * z)
        WHEN (x + y * z) > (x * y * z)
            and (x + y * z) > (x * (y + z))
            and (x + y * z) > ((x + y) * z) THEN (x + y * z)
        WHEN ((x + y) * z)  > (x * y * z)
            and ((x + y) * z)  > (x + y * z)
            and ((x + y) * z)  > (x * (y + z)) THEN ((x + y) * z)

        END AS max_result
FROM numbers;
SELECT GREATEST(
               x * (y + z),
               x * y * z,
               x + y * z,
               (x + y) * z
       ) AS max_result
FROM numbers;
/* Згрупуй всіх людей за віком та порахуй людей, що мають однаковий вік.*/
SELECT age, COUNT(age) AS people_count
FROM people
GROUP BY age
/* кожне поля одного стовпчика містить довжину рядка поля праворуч */
SELECT
    length(name) AS id,
    length(legs::text) AS name,
    length(arms::text) AS legs,
    length(characteristics) AS arms,
    length(id::text) AS characteristics
FROM monsters;
/* do not forget about comma */
SELECT "US" as location, * FROM ussales
WHERE price > 50

UNION ALL

SELECT 'EU' as location, * FROM eusales
WHERE price > 50;

/*  */