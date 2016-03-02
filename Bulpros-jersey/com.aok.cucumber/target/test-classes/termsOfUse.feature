@smokeTestTU
Feature: The user gets Terms of Use

Scenario Outline: The document 'Terms of use' is loaded successfully

When the user logs with "<username>" and "<password>" and opens Legal notices
Then Terms of Use is displayed successfully

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	