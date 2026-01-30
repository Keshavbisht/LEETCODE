# Write your MySQL query statement below
Select email as Email
from (Select email, COUNT(id) as c from Person Group by email) as nt
where nt.c > 1;
