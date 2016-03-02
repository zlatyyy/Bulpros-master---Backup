@smokeTestGCC
Feature: Get user cart content
 
Scenario Outline: Get user cart content
When user logs with his "<username>" and his "<password>"
And the user gets cart
Then the response is returned

Examples:
|username											|password	 		|		
|userName=automationpass@bulpros.com				|password=qwertyuiop1|
|userName=automationnon@bulpros.com   				|password=qwertyuiop1|
