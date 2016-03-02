@smokeTestLO
Feature: The user can logout

Scenario Outline: The logout is successfully

Given an user
When this user logs with "<username>" and "<password>"
Then the logout is successfully

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	