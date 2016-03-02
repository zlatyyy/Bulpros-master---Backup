@smokeTestGP
Feature: All products are listed

#DO NOT CHANGE EXISTING PRODUCTS AND PRODUCT CATEGORIES IN KONAKART!!!

Scenario Outline: Load products without filter
Given the products in KonaKart 
When the user logs in with "<username>" and "<password>" and does not apply filter 
Then the products are loaded

Examples:
|username			 					|password			|					
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|	
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	


Scenario Outline: Load products by category filter
Given the products in KonaKart 
When the user logs in with "<username>" and "<password>" and filters products by category "<categoryId>"
Then the products are loaded

Examples:
|username			 					|password				|categoryId|	
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|2		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|36		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|23		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|3		|			


Scenario Outline: Load products by search name filter
Given the products in KonaKart 
When the user logs in with "<username>" and "<password>" and filters by search "<nameSearch>"
Then the products are loaded

Examples:
|username			 					|password				|nameSearch		|						
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|Red corner		|		
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|iphone			|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|pluto			|				
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|Matrox			|


Scenario Outline: Load products by price
Given the products in KonaKart 
When the user logs in with "<username>" and "<password>" and filters to "<priceTo>"
Then the products are loaded

Examples:
|username			 					|password				|priceTo|							
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|1000|			
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|2500|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|60000|					
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|500|