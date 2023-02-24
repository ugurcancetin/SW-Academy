# SW Design Workshop

## Problem Statement

Product owner has noticed that the application requires order reporting functionality.
It is highlighted that these type of reports can vary in the future depending on order and basket types.

However, for now, it is required to have only two type as shown in the samples below. <br/>

Requirements are as following:
* Print ID of each order
* Print Date of each order
* Print Quantity or measurement of each order
* Print Total cost of each order
* Print finally the total cost of complete basket/order items.

P.S: It doesn't have to be one to one copy.<br/>

An Example Outputs: <br/>


#### Summary Report
Just high level summary of orders.
****************************
1. 100	2023-01-20	2	12.0
2. 200	2023-01-20	2	25.0
3. 300	2023-01-20	2	13.0<br /><br />
   Total 50.0
*****************************

#### Detailed Report
Add each item name and its cost to report

1. 100 	2023-01-20<br />
   Chips	10.0<br />
   Beer	2.0 <br />
   Total  12.0

2. 200 	2023-01-20<br />
   Cookies	5.0<br />
   Baklava	20.0<br />
   Total  25.0

3. 300 	2023-01-20<br />
   Burger	8.0<br />
   Fries	5.0<br /> <br />
   Total  13.0 <br /> <br />  
   Grand Total 50.0
----------------------------------------