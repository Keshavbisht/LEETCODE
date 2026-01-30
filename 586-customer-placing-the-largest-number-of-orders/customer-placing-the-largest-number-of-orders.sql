# Write your MySQL query statement below

Select n.customer_number as "customer_number"
from (
select customer_number, COUNT(order_number) as ct from Orders group by customer_number order by ct DESC) as n
limit 1;