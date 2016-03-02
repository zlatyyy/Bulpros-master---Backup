@smokeTestGBSet
Feature: The user wants to get beacon settings

Scenario Outline: Get beacon settings

When an user fills "<username>" and "<password>" and gets beacon settings
Then the user can see uuid 

Examples:
|username			 					|password				|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|	