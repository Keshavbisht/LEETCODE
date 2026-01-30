# Write your MySQL query statement below
SELECT name as "Customers"
from Customers as c
Left JOIN Orders as o on c.id = o.customerId
where customerID is NULL;

