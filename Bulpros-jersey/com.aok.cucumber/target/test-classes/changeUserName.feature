@smokeTestCUN
Feature: The user wants to change his/her username
 
Scenario Outline: Change username
When an user logs using "<username>" and "<password>"
And the user changes old username with "<newUsername>"
Then the username is changed and the "<responseCode>" is correct

Examples:
|username										|password				|newUsername 					|responseCode| 
|userName=automationusersss@bulpros.com			|password=qwertyuiop1	|automationnewuser@bulpros.com	|DWT-USR-SCS-002|
