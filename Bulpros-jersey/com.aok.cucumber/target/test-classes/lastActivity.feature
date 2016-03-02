@smokeTest
Feature: See the last activity

Scenario Outline: See lastly added activity
Given there is at least one added activity 
When user logs with "<username>" and "<password>"
When get the lastly activity
Then the response is SCS

Examples:

|username			 					|password|		
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|	
|userName=automationpass@bulpros.com	|password=qwert111111|
|userName=automationpass@bulpros.bbb 	|password=qwertyuiop1| 	
|userName=automblocked@bulpros.com 		|password=wrong	| 
