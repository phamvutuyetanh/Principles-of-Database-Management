# Principles-of-Database-Management
## TOPIC: E-COMMERCE PORTAL for USED FURNITURE SALES

## Table of Contents 📑

[I. Introduction ☀️](#Intro)
- [1. Background](#background)
- [2. Requirement](#requirement)
- [3. Goal🎯](#goal)
- [4. Installation ](#install)
  
[II. Techniques](#Techniques)

[III. ERD](#Dashboard)

[IV. Components of ERD ](#Component)
- [1. Account entity ](#account)
- [2. Admins entity ](#admin)
- [3. Employees entity ](#employee)
- [4. Customers entity ](#customer)
- [5. Product1 entity ](#product1)
- [6. Photo weak entity ](#photo)
- [7. Orders entity ](#order)
- [8. Product2 entity ](#product2)
- [9. Relationship ](#relationship)

[V. Normalization ](#normalization)

===========================

<a name="Intro"></a>
## I. Introduction
<a name="background"></a>
### 1. Background
E-commerce portal for used furniture sales. This project is for a startup that is acquiring used furniture from users at a price, refurbishing it and selling it off at margin. The result of the project can help company to store and manage the total of second-hand furniture that is currently being sold/ bought, the total customer of the company, the employee, sales revenue from transactions, …

<a name="requirement"></a>
### 2. Requirement
Here is a list of basic requirements for system
<ol>
    <li> Admin can
        <ul>
            <li> Keep track all products are being sold </li>
            <li> Decide whether to buy or not product from customer </li>
            <li> Govern employees </li>
        </ul>
    <li> Employee can
        <ul>
            <li> Sell, add, delete, update product </li>
            <li> Process customer orders</li>
        </ul>
    <li> Customer can
        <ul>
            <li> Sign up and set up the profile </li>
            <li> Search for their required products and checkout </li>
            <li> See the expected time of delivery </li>
            <li> View/add/remove content from shopping cart </li>
            <li> Sell used furniture </li>            
        </ul>
</ol>

<a name="goal"></a>
### 3. Goals
I got the chance to study SQL and use the programming abilities they had acquired by building a database model of a furniture company. Using the information that has been taught in ways like:
<ul>
<li>	Analyze data requirements</li>
<li>	Define The entities, attributes, relationship,..</li>
<li>    Insert data</li>
<li>    Data query</li>
<li>    Connect database and interface design by using java </li>
</ul>

<a name="install"></a>
### 4. Install
You can open the terminal on your IDE and clone the repo: 

` https://github.com/phamvutuyetanh/Principles-of-Database-Management.git `

<a name="Techniques"></a>
## II. Techniques
<ul>
<li>	IDE for form programming: VSCode, NetBeans, SQL Sever</li>
<li>	Draft the ERD : ERDplus</li>
<li>    Programming languages: Java, SQL
</ul>

<a name="ERD"></a>
## III. ERD
Base on the basic requirements, the complete ERD and database diagram are designed:  

<img src="Image\ERD.png" width = 800 height = 300>

<img src="Image\Database_Diagram.png" width = 800 height = 300>

<a name="Component"></a>
## IV. Component of ERD
It is the time to describe all components of ERD

<a name="account"></a>
### 1. Account entity
This entity sets contains login information of all three entity sets: Admin, Employees, Customer

<ul>
    <li> AccountID: Unique ID distinguishes accounts from each other. </li>
    <li> LoginName: Username </li>
    <li> Password: this attribute is to login in account </li>
    <li> Accounttype: Admin/Customer/Employee </li>
</ul>

<a name="admin"></a>
### 2. Admins entity
The entity sets have a relationship with three other  entity sets. Specifically, administrators can record the clothing department, having the ability to decide whether  to buy second-hand products from customers. In addition, the administrator will be the person who directly assigns tasks and controls the work situation of employees.

<ul>
    <li> AdminID : There are many managers in the same website, so separating them requires separate ID. </li>
    <li> AdminID : There are many managers in the same website, so separating them requires separate ID.</li>
    <li> AdminName: Their name is recorded here.</li>
    <li> AdminPhone: In the event of an emergency or any mishap, employees need to contact their manager</li>
</ul>

<a name="employee"></a>
### 3. Employees (Staff) entity
This entity provides a list of employees provided with a unique ID to log into their own accounts to systematically perform their duties. This entity directly sells or updates/ posts/deletes clothing, so it has a link to the actual clothing 

<ul>
    <li> EmpID:  Each employee has been assigned a unique ID to allow them to have access to a specific section, this information is stored in this property.</li>
    <li> EmpName: Their name is recorded here.</li>
    <li> EmpEmail: To pass on any information or to communicate with employees about business matters.</li>
    <li> EmpPhone: It is necessary to record their phone number when emergencies at work.</li>
</ul>

<a name="customer"></a>
### 4. Customers entity
Customers have a big impact on the product because they are the key stakeholders in the company. Customers are those who purchase goods from retailers, generating revenue for them. Customers have the option to look for and purchase things based on their needs

<ul>
    <li> CusID: Each customer needs a unique ID to distinguish customers from each other. </li>
    <li> CusName: Their name is recorded here.</li>
    <li> CusPhone: Customer’s phone number required for delivery</li>
    <li> CusAddress:  Address provided required for delivery</li>
    <li> CusEmail:  This attribute includes customer’s email to provide for us expected time of delivery</li>
</ul>

<a name="product1"></a>
### 5. Product1 entity
Products are for sale on the web. If a customer has any requirement, then this entity will further assist the customer to check according to customer request. It needs sundry properties.

<ul>
    <li> Product1ID: Each product has a unique ID to distinguish it</li>
    <li> Product1Name: Production’s name</li>
    <li> Condition (%)</li>
    <li> Quantity: The number of productions of each type</li>
    <li> ProductType: The property divides clothing data into distinct groups.</li>
    <li> Material: Product material </li>
    <li> Price: Price of product </li>
</ul>

<a name="photo"></a>
### 6. Photo weak entity
Each product type also has its own image so we say production 1 entity set has a connection with photo entity set

<ul>
    <li> SequenceNo: Since each item may contain multiple images, this will be the order for that image.</li>
    <li> PhotoExtends: Store product images.</li>
</ul>

<a name="order"></a>
### 7. Orders entity
This entity stores all information about transactions
<ul>
    <li> OrderID: Each order has a unique ID to distinguish it</li>
    <li> Oder_Date: This attribute store the day when customer buy product</li>
    <li> ExpectedDelivery: The expected time of product arrival must be communicated to the customer </li>
    <li> DeliveryFee </li>
</ul>

<a name="product2"></a>
### 8. Product2 entity
Customers with administrator clearance can opt to sell things to the firm. As a result, this entity is related to both the customer and admin

<ul>
    <li> Product2ID: Each product has a unique ID to distinguish it </li>
    <li> Product2Name: Production’s name</li>
    <li> Product2Ext: Images of store products</li>
    <li> PriceSuggest: The seller's desired price.</li>
    <li> Quantity: The number of productions </li>
</ul>

<a name="relationship"></a>
### 9. Relationship

| Relationship  | Attribute on relationship        | Entity sets in relationship | Cardinality |
| ------------- |:--------------------------------:|-----------------------------|------------|
| Record        |                                  | Admin & Product1            | One to Many        |
| Govern        |                                  | Admin & Employees           | One to Many        |
| Invoice       | Date_, Quantity, PriceProduct,   | Admin & Product2            | Many to Many     |
| Purchase      |                                  | Customer & Product2         | One to Many        |
| Contains(Order Details)| SequenceNo, Quantity    | Customer & Product1         | Many to Many     |
| Search        |                                  | Customer & Product1         | Many to Many     |
| Sell          |                                  | Employee & Product1         | One to Many        |
| Includes      |                                  | Product1 & Photo            | One to Many        |
| Has           |                                  | Admin & Account             | One to One         |
| Has           |                                  | Employee & Account          | One to One         |
| Has           |                                  | Customer & Account          | One to One         |
| Buy           |                                  | Order & Customer            | Many to One      |

<a name = "normalization"></a> 
## V. Normalization
The DataBase Diagram is verified on three level: 
<ol>
    <li> 1NF: A relational database that has all attributes in a tuple must have a single value from the domain of that attribute, and the domain of an attribute only include atomic values. Therefore, database is already in the first normal form. </li>
    <li> 2NF: A relational database is in first normal form and every non-key characteristic is completely functionally dependent on the primary key. Therefore, database is already in the second normal form. </li>
    <li> 3NF: A relational database is in 2NF and non-transitive functional dependency of non-prime attributes on any super key. Therefore, database is already in the third normal form.</li>
</ol>