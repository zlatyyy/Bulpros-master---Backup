@smokeTestSPC
Feature: The user can see all visible status categories

Scenario Outline: Load all status categories

Given the partner categories in KonaKart 
When "<username>" "<password>" are entered
Then the partner categories are loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	