    select e.Name as Employee from Employee e join Employee em on e.ManagerId=em.Id where e.Salary > em.Salary;
