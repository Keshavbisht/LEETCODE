# Write your MySQL query statement below
-- Select c.name from Customer as c
-- where c.referee_id != 2 OR c.referee_id is NULL;
select name from customer where referee_id is null or referee_id!=2;