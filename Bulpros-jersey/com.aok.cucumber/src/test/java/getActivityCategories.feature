@smokeTestGACat
Feature: The user wants to get activity categories

Scenario Outline: Get activity categories

When some user fills "<username>" and "<password>" and get activity categories
Then the activity categories are displayed

Examples:
|username			 					|password				|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|