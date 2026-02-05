# Write your MySQL query statement below
Select v.customer_id as "customer_id", COUNT(*) as "count_no_trans"
from Visits as v
Left Join Transactions as t
on v.visit_id = t.visit_id
Where transaction_id is NULL
group by v.customer_id;