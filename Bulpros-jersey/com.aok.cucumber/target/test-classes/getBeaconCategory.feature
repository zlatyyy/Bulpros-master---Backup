@smokeTestGCatB
Feature: The user wants to get beacon category according to uuid

Scenario Outline: Get beacon category

When an user fills "<username>" and "<password>" and submits "<uuid>" "<minor>" and "<major>"
Then the categoty for the beacons is displayed

Examples:
|username			 					|password				|uuid									|minor		|major|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|7b2f11e4-b035-4cc4-9b70-a164ff0efdeb	|200		|100|	
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|7b2f11e4-b035-4cc4-9b70-a164ff0efdeb	|100		|200|	