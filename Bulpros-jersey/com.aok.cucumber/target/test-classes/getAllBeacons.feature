@smokeTestGAllB
Feature: The user wants to get all beacons

Scenario Outline: Get all beacons

When the user fills "<username>" and "<password>" and gets all beacons
Then the beacons are displayed

Examples:
|username			 					|password				|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|	