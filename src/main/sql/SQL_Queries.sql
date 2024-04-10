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
SELECT CASE
           WHEN (x * (y + z)) > (x * y * z)
               and (x * (y + z)) > (x + y * z)
               and (x * (y + z)) > ((x + y) * z) THEN (x * (y + z))
           WHEN (x * y * z) > (x * (y + z))
               and (x * y * z) > (x + y * z)
               and (x * y * z) > ((x + y) * z) THEN (x * y * z)
           WHEN (x + y * z) > (x * y * z)
               and (x + y * z) > (x * (y + z))
               and (x + y * z) > ((x + y) * z) THEN (x + y * z)
           WHEN ((x + y) * z) > (x * y * z)
               and ((x + y) * z) > (x + y * z)
               and ((x + y) * z) > (x * (y + z)) THEN ((x + y) * z)
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
SELECT length(name)            AS id,
       length(legs::text)      AS name,
       length(arms::text)      AS legs,
       length(characteristics) AS arms,
       length(id::text)        AS characteristics
FROM monsters;
/* do not forget about comma */
SELECT "US" as location, *
FROM ussales
WHERE price > 50

UNION ALL

SELECT 'EU' as location, *
FROM eusales
WHERE price > 50;

/*  */
select *
from pupil
where first_name like '_____' where publish_year between 2011 and 2015
where first_name like 'A%' /
where title not like 'F%'
where mother_phone is null or father_phone is null
WHERE city NOT IN ('Kyiv', 'Irpin') / name in ('Eugen', 'Anna', 'Volodymyr') /price in (90, 95, 125)
where birth_date NOT BETWEEN '2005-08-28' AND '2007-06-12'

/*  */
select department.name as department_name, sum(employee.salary) as amount_of_money
from department
         inner join employee
                    on employee.department_id = department.id
group by department_name
having count(employee.id) > 3
order by amount_of_money desc
/* */
select category.name as category_name, max(product.price) as max_price
from category
         inner join product
                    on category.id = product.category_id
group by category_name
having count(product.id) > 2
order by max_price
/* */
select scoreboard.subject as subject, avg(mark) as average_mark
from scoreboard
         inner join pupil
                    on pupil.id = scoreboard.pupil_id
where first_name = 'Eugen' and  last_name = 'Tsven'
group by subject
having avg(mark) > 9
/*Знайди назви категорій, у яких сума кількості всіх товарів становить понад 80. */
select category.name as category_name, sum(product.amount) as total_amount
from category
         inner join product
                    on category.id = product.category_id
group by category_name
having sum(product.amount) > 80
/* Напиши SQL-запит для отримання повторюваних записів із цієї
   таблиці. Результат повинен містити чотири стовпчики:
   score, review, user_id та number_of_repeats. Ось приклад двох повторюваних записів,
   тому що score, review та user_id є однаковими:*/
SELECT score, review, user_id, COUNT(*) AS number_of_repeats
FROM reviews
GROUP BY score, review, user_id
HAVING COUNT(*) > 1;