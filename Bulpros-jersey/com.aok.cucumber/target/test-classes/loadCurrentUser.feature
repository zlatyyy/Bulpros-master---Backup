@smokeTestCU
Feature: The user profile is loaded the user log in to AOK

Scenario Outline: Load user profile

Given There is already created user account  
When "<username>" and "<password>" are filled
Then the user profile is loaded

Examples:

|username			 					|password|		
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|	
|userName=automationnon@bulpros.com		|password=qwertyuiop1|


