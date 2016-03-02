@smokeTestFAQ
Feature: The user can see frequently asked questions

Scenario Outline: Load frequently asked questions

Given the list with frequently asked questions
When some user enters "<username>" and "<password>"
Then the FAQ are loaded

Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	