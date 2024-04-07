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
- [1. Pie chart ](#pie)
- [2. Area chart](#area)
- [3. Bubble chart](#bubble)
- [4. Rank chart ](#rank)
- [5. Geo Map ](#map)

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
Base on the basic requirements, the complete ERD is designed:  

<img src="Image\ERD.png" width = 800 height = 300>

<a name="Component"></a>
## IV. Component of ERD
It is the time to describe all components of ERD
### 1. Pie chart

<img src="Source_Code\image\PieChart.png" width = 800 height = 300>

<ul>
    <li> Abstract task for chart: Comparison of proportion and  general overview </li>
    <li> Structure of pie chart: Mark(fraction of area of circles) & Channels (angle, color, label) </li>
    <li> Interaction:
        <ol>
            <li>Hover information</li>
            <li>Highlighting and selection</li>
            <li>Cross - chart interactivy </li>
            <li>Dynamic update</li>
        </ol>
    </li>
</ul>

<a name="area"></a>
### 2. Area chart
<img src="Source_Code\image\AreaChart.png" width = 800 height = 300>

<ul>
    <li> Abstract task for chart: 
        <ol>
            <li>Comparing the sales performance of different product categories over time
            </li>
            <li>Ilustrating the changes over time </li>
            <li>Cross - chart interactivy </li>
            <li>Outlier Detection</li>
        </ol>
    </li>
    <li> Structure of area chart: Mark(Area) & Channels (x-axis, y-axis, the color) </li>
    <li> Interaction:
        <ol>
            <li>Linking and brushing</li>
            <li> Transition</li>   
            <li>Highlighting and selection</li>
            <li>Cross - chart interactivy </li>
            <li>Dynamic update</li>
        </ol>
    </li>
</ul>

