Feature: The user wants to reset a password

@smokeTestResPass
Scenario Outline: Reset a password
Given the user wants to reset password
When the user puts "<token>" and "<newPassword>"
Then the new password is activated and "<responseCode>" is correct

Examples:
|token			 						|newPassword			|responseCode| 
|token=esekjam8ih42s7kanlcvspqeoi   	|newPassword=qwertyuiop1 	|DWT-USR-SCS-004|
|token=esekjam8ih42s7kanlcvspqeoi		|newPassword=qwer			|DWT-INCORRECTPWD-ERR|

