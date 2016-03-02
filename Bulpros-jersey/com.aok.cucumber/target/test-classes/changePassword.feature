@smokeTestCP
Feature: The user wants to change his/her password
#DWT-USR-SCS-004.EN	Password changed. 

 
Scenario Outline: Change password
Given a password
When user logs with a "<username>" and "<password>"
When the user with "<email>" changes "<oldPassword>" with a "<newPassword>"
Then the response "<responseCode>" is correct

Examples:
|username										|password				|oldPassword	|newPassword 	|email									|responseCode| 
|userName=automationpass@bulpros.com			|password=qwertyuiop1	|qwertyuiop1	|qwertyu		|automationpass@bulpros.com				|DWT-INCORRECTPWD-ERR|
|userName=automationpass@bulpros.com			|password=qwertyuiop1	|qwertyuiop1	|qwertyuiop2	|automationpass@bulpros.com				|DWT-USR-SCS-004|
