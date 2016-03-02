@smokeTestDisU
Feature: The user can get disabled

Scenario Outline: Disabled user

When the user enters "<username>" and "<password>" and send request
Then the user is disable

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	