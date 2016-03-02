@smokeTestGS
Feature: All available sports for manual input are loaded when the user log in to AOK

Scenario Outline: Load sports in store

Given defined sports 
When user logs using "<username>" and "<password>"
Then the sports are loaded

Examples:

|username			 					|password|		
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|	
|userName=automationnon@bulpros.com		|password=qwertyuiop1|
|userName=automationpass@bulpros.bbb 	|password=qwertyuiop1| 	

