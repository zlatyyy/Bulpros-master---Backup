@smokeTestPB
Feature: The user can see his/her point balance history

Scenario Outline: Load point balance history

Given there is a created user 
When "<username>" and "<password>" are entered
Then the point balance history is loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	


