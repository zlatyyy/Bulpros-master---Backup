@smokeTestSP
Feature: Status partners are listed

#DO NOT CHANGE EXISTING PARTNERS IN KONAKART!!!
#CREATE NEW PARTNUR WITH PRODUCTS
#DWT-ESHP-ERR-012.EN	Error retrieving status partners.

Scenario Outline: Load status partners by category filter
Given the partners in KonaKart 
When an "<username>" and a "<password>" are entered
And the user fillters by category "<categoryId>"
Then the status partners are loaded

Examples:
|username			 					|password				|categoryId	|size	|start|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|45			|10		|0|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|49			|200	|0|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|50			|100	|10|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|45			|1		|0|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|64			|150	|25|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|47			|100	|100|

Scenario Outline: Load status partners by partner filter
Given the partners in KonaKart 
When an "<username>" and a "<password>" are entered
And the user fillters by partner "<partner>"
Then the status partners are loaded

Examples:
|username			 					|password				|partner							|order	|								
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|BLN - Charlottenburg-Wilmersdorf	|ORDER_BY_NAME_ASCENDING|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|BLN - Mitte						|ORDER_BY_NAME_ASCENDING|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|MV - Schwerin						|ORDER_BY_NAME_DESCENDING|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|BRB - Elbe-Elster					|ORDER_BY_NAME_ASCENDING|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|BLN - Mitte						|ORDER_BY_NAME_ASCENDING|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|MV - Vorpommern-Rügen				|ORDER_BY_NAME_ASCENDING|


	