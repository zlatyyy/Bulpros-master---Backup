@smokeTestGCPr
Feature: Get one status partner through partnerID
Scenario Outline: Get certain status partner
When the user logs in with "<username>" and "<password>" and add "<partnerID>"
Then the partner is loaded

Examples:
|username			 					|password				|partnerID|	
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|73		|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|74		|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|75		|		
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|76		|		