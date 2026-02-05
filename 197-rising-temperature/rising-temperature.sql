# Write your MySQL query statement below
Select w1.id
from Weather as w1
Join Weather as w2
on DATEDIFF(w1.recordDate, w2.recordDate) = 1
and w1.temperature > w2.temperature;

-- SELECT w1.id
-- FROM Weather w1
-- JOIN Weather w2
-- ON DATEDIFF(w1.recordDate, w2.recordDate) = 1
-- AND w1.temperature > w2.temperature;
