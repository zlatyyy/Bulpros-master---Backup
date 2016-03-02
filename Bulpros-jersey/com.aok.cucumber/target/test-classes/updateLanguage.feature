@smokeTest
Feature: User wants to update his/her profile

@smokeTestUPR
Scenario Outline: Update language
Given user profile with "<location>"
When the user logs in AOK with "<username>" and "<password>"
When the user submits the change in "<location>"
Then the "<responseCode>" and "<description>" are correct

Examples:
|username										|password	 			|location	|responseCode		|description|
|userName=automationde@bulpros.com				|password=qwertyuiop1	|de_DE		|DWT-USR-SCS-002	|Nutzer erfolgreich aktualisiert.|
|userName=automationde@bulpros.com   			|password=qwertyuiop1   |en_US		|DWT-USR-SCS-002   	|Update user succeeded.|
