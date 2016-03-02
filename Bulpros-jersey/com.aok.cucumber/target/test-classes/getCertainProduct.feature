@smokeTestGCP
Feature: Get one product through productID
Scenario Outline: Get certain product
When the user logs in with "<username>" and "<password>" and selects "<productID>"
Then the product is loaded

Examples:
|username			 					|password				|productID|	
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|56		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|19		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|30		|	
|userName=automationpass@bulpros.com	|password=qwertyuiop1	|35		|	