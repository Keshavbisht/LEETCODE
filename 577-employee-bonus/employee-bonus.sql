# Write your MySQL query statement below

Select e.name as "name", b.bonus as "bonus"
from Employee as e
LEFT JOIN Bonus as b
on e.empId = b.empId
where bonus < 1000 or bonus is null;

