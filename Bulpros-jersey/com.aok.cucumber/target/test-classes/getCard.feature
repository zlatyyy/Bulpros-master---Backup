@smokeTestCard
Feature: The user can get card for certain status level

Scenario Outline: Get card for certain status level

When the user fills "<username>" and "<password>"
Then the status card is loaded if "<response>" is 1

Examples:
|username			 					|password				|response|			
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1	|0|