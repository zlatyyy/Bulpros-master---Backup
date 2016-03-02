@smokeTestAFeed
Feature: Requests a feedback from the administrator

Scenario Outline: Requests a feedback

When an user authenticates with "<username>" and "<password>"
And send request with "<contact>" by some of "<contact-methods>"
Then the connection is successfully

Examples:
|username			 						|password				|contact						|contact_method	|
|userName=automation.pending@bulpros.com   	|password=qwertyuiop1	|automation.pending@bulpros.com	|e-mail			|
|userName=automation.pending@bulpros.com   	|password=qwertyuiop1	|0896562315						|phone			|				