@smokeTestD
Feature: The user can see all districts when open a drop-down

Scenario Outline: Load all districts

Given the districts in KonaKart 
When "<username>" and the "<password>" are entered
Then the districts are loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	