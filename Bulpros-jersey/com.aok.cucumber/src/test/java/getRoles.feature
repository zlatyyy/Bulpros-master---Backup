@smokeTestGetR
Feature: Display current user information

Scenario Outline: Get user roles

When "<username>" and the "<password>" entered
Then the user roles are loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	