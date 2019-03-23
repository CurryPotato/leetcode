    SELECT c.`name` Customers FROM customers c WHERE c.id NOT IN (SELECT o.CustomerId from orders o);
