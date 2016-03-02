@smokeTestCav
Feature: The user wants to change his/her avatar

Scenario Outline: Change the avatar

When some user fills "<username>" and "<password>" and changes avatar
Then the avatar is changed

Examples:
|username			 					|password				|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|