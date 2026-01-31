# Write your MySQL query statement below
Select class as "class"
from Courses Group by class
having Count(*) >= 5;