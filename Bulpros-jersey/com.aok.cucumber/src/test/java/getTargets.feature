@smokeTestGTg
Feature: Get all targets
Scenario Outline: Get all targets
When the user enters "<username>" and "<password>"
Then the targets are loaded

Examples:
|username			 					|password				|		
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|	
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|		