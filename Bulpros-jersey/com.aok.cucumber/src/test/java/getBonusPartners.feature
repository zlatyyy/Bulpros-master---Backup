@smokeTestGbp
Feature: Get all bonus partners with pagination
Scenario Outline: Get all bonus partners
When the user logs in with "<username>" and "<password>" and gets all bonus partners without filter
Then the bonus partners are loaded

Examples:
|username			 					|password				|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|


Scenario Outline: Get all bonus partners
When the user logs in with "<username>" and "<password>" and gets bonus partners by "<tags>"
Then the bonus partners are loaded

Examples:
|username			 					|password				|tags|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|#iBeacon	|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|#QR-Code	|	

	
Scenario Outline: Get all bonus partners
When the user logs in with "<username>" and "<password>"and gets bonus partners by search "<nameSearch>"
Then the bonus partners are loaded

Examples:
|username			 					|password				|nameSearch|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|Boev|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|Dummy	|	


Scenario Outline: Get all bonus partners
When the user logs in with "<username>" and "<password>" and gets bonus partners by category "<categoryId>"
Then the bonus partners are loaded

Examples:
|username			 					|password				|categoryId|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|2	|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|36	|
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|23	|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|3	|		
	
	