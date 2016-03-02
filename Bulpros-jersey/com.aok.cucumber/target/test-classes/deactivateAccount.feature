@smokeTestDAA
Feature: The user wants to delete/deactivate his/her account
#DWT-DELETE-ERR-004.EN	Deletion failed. Wrong password.
#DWT-DELETE-ERR-005.EN	Deletion failed. You are enrolled in the program “FitMit AOK” and cannot delete your account.
#DWT-USR-SCS-009.EN	Delete user succeeded.
 
Scenario Outline: Delete/Deactivate account
Given user accounts
When our user logs with "<username>" and "<password>"
When the user fills the "<passwords>"
Then the responseCode "<responseCode>" is correct

Examples:
|username										|password				|passwords				|responseCode| 
|userName=automationdelete@bulpros.com			|password=qwertyuiop1	|password=qwertyu		|DWT-DELETE-ERR-004|
|userName=automationpass@bulpros.com			|password=qwertyuiop1	|password=qwertyuiop1	|DWT-DELETE-ERR-005|
|userName=automationdelete@bulpros.com			|password=qwertyuiop1	|password=qwertyuiop1	|DWT-USR-SCS-009|