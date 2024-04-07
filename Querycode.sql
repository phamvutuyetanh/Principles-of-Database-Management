/* QUERY CODE*/
/* Query 1*/
Select*From photo;

/* Query 2*/
SELECT * FROM Employees 
WHERE AdminID= 'Admin2';

/* Query 3*/
SELECT DISTINCT Product1Name FROM Product1;

/* Query 4*/
SELECT * FROM Product1 
WHERE Material = 'MDF';

/* Query 5*/
SELECT * FROM  Product1
WHERE Quantity = 1;

/* Query 6*/
SELECT * FROM product2 
WHERE PriceSuggest >=500.00;

/* Query 7*/
SELECT CusName 
FROM  Customers  
WHERE CusAddress LIKE '%Ha Noi%';

/* Query 8*/
SELECT EmpID FROM Employees
WHERE EmpName LIKE 'Nguyen%';

/* Query 9*/
SELECT Material, MAX(Price) as maxprice, MIN(Price) as minprice
FROM Product1
GROUP BY Material;

/* Query 10*/
SELECT COUNT(Quantity) AS TotalProfuct
FROM Product1;

/* Query 11*/
SELECT COUNT (*) AS countproduct2
FROM Product2
WHERE Quantity>3;

/* Query 12*/
SELECT CusName FROM Customers
WHERE CusName LIKE 'Sùng%';

/* Query 13*/
SELECT SUM(Price) AS TotalProductPrice FROM Product1;
/* Query 14*/
SELECT ProductType, AVG(Price) AS avg_price  
FROM Product1
Group by ProductType;

/* Query 15*/
SELECT Product1Name, Price, Condition FROM Product1
WHERE Price BETWEEN 4000000.00 AND 8000000.00;

/* Query 16*/
Select C.CusID, C.CusName
From Customers as C
Where CusID NOT IN (Select O.CusID 
From Order_ as O)

/* Query 17*/
SELECT MAX((table1.Price*table1.Quantity)+table2.DeliveryFee) as max, MIN((table1.Price*table1.Quantity)+ table2.DeliveryFee) as min 
FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, 
(SELECT Order_.OrderID, DeliveryFee From Order_ ) as table2 
WHERE table1.OrderID = table2.OrderID ;

/* Query 18*/
SELECT * FROM Product1
WHERE Condition = 
(SELECT MIN(Condition) FROM Product1);

/* Query 19*/
SELECT * FROM Product1
WHERE Price = 
(SELECT MAX(Price) FROM Product1);

/* Query 20*/
SELECT COUNT(CusID) AS HCM_Cus 
FROM Customers
WHERE CusAddress LIKE '%Ho Chi Minh City%';

/* Query 21*/
SELECT CusID, Product2Name, PriceSuggest 
FROM Product2 
WHERE PriceSuggest >=1000000.00   
ORDER BY CusID DESC;

/* Query 22*/
SELECT Product1ID, Product1Name 
FROM Product1 WHERE Material= 'wood' AND Condition >= 80 
ORDER BY Product1Name;

/* Query 23*/
Select P.CusID, Count(Distinct CusID) as count
From Product2 as P, Invoice as I
Where P.Product2ID = I.Product2ID
Group by P.CusID
Order by count DESC;

/* Query 24*/
SELECT Material, MAX(Price) as maxprice, MIN(Price) as minprice
FROM Product1 
GROUP BY Material 
HAVING MIN(Price) >=900

/* Query 25*/
Select Product1ID, Product1Name
From Product1
Where Product1ID NOT IN (Select O.Product1ID From OrderDetails AS O)

/* Query 26*/
SELECT Month, SUM(Sum) as TotalFee From (SELECT Month,(table1.Price*table1.Quantity)+table2.DeliveryFee as Sum FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, (SELECT Month(Order_Date) as Month, Order_.OrderID, DeliveryFee From Order_ Where Year(Order_Date)='2022' ) as table2 WHERE table1.OrderID = table2.OrderID) as table3 group by Month; 

/* Query 27*/
Select E.EmpID, E.EmpName From Employees as E
                               INNER JOIN

 (SELECT TOP 3 table2.EmpID, SUM ((table1.Price*table1.Quantity)+  table2.DeliveryFee) as Fee 
 FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, 
 (SELECT EmpID, Order_.OrderID, DeliveryFee From Order_  Where Year(Order_Date) = '2022') as table2 
 WHERE table1.OrderID = table2.OrderID 
 Group by table2.EmpID Order by Fee DESC) as table3 ON E.EmpID = table3.EmpID;

/* Query 28*/
SELECT * FROM (SELECT table2.EmpID, SUM((table1.Price*table1.Quantity) + table2.DeliveryFee) as Sum, Count(DISTINCT table2.EmpID) as TotalOrder FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, (SELECT EmpID, OrderID, DeliveryFee From Order_) as table2 WHERE table1.OrderID = table2.OrderID Group by table2.EmpID) as table3
LEFT JOIN
(SELECT E.EmpID, AdminID, EmpName From Employees as E) as table4 
ON table3.EmpID = table4.EmpID;

/* Query 29*/
SELECT table4.CusID, CusName, Sum FROM (SELECT TOP 3 table2.CusID,SUM((table1.Price*table1.Quantity)+table2.DeliveryFee) as Sum FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, (SELECT CusID, Order_.OrderID, DeliveryFee From Order_) as table2 WHERE table1.OrderID = table2.OrderID Group by table2.CusID Order by Sum DESC) as table3
LEFT JOIN 
(SELECT C.CusID, CusName From Customers as C) as table4
ON table3.CusID = table4.CusID ;

/* CREATE VIEW*/
/* CREATE VIEW 1*/
	CREATE VIEW VWCustomers
	AS
	SELECT CusID, CusName, CusEmail
	FROM Customers;

/* CREATE VIEW 2*/
CREATE VIEW VWOrder_2022
AS
SELECT table4.CusID, CusName,CusPhone, CusAddress, table3.OrderID, Sum FROM 
(SELECT table2.CusID,table2.OrderID,SUM((table1.Price*table1.Quantity) +table2.DeliveryFee) as Sum FROM (SELECT P.Price,O.Quantity, O.OrderID FROM OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID) as table1, ( SELECT CusID, OrderID,Order_Date, DeliveryFee From Order_) as table2 WHERE table1.OrderID = table2.OrderID Group by table2.OrderID, table2.CusID) as table3
LEFT JOIN
(SELECT C.CusID, CusName, CusPhone, CusAddress
From Customers as C) as table4
ON table3.CusID = table4.CusID ;

/* CREATE VIEW 3*/
CREATE VIEW VWAccount
AS
SELECT * FROM ACCOUNT

/* CREATE VIEW 4*/
CREATE VIEW Customer_Hanoi
AS
SELECT CusName 
FROM  Customers  
WHERE CusAddress LIKE '%Ha Noi%';

/* CREATE VIEW 5*/
CREATE VIEW Product2_mostcustomers
AS
SELECT TOP 3 CusID, Product2Name, PriceSuggest 
FROM Product2 
WHERE PriceSuggest >=1000000.00   
ORDER BY CusID DESC;


