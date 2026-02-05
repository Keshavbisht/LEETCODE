# Write your MySQL query statement below
Select t2.unique_id as "unique_id", t1.name as"name"
from Employees as t1
Left Join EmployeeUNI t2 on t1.id = t2.id;