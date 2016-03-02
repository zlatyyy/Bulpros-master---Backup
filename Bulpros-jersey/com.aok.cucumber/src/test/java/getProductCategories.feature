Feature: The user wants to see all Product Categories.

@smokeTestGCA
Scenario Outline: Product categories
Given the product categories in KonaKart 
When we enter "<username>" and "<password>"
Then the product categories are loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	
