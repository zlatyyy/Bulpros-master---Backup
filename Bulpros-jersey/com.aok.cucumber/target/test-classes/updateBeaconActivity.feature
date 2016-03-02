@smokeTestUBA
Feature: The user wants to submit beacon activity

Scenario Outline: Submit beacon activity

When an user enters "<username>" and "<password>" and submits beacon activity with "<beaconUI>"
Then the "<responseCode>" is according to the entered beacon id

Examples:
|username			 					|password				|beaconUI								|responseCode|
|userName=automationpass@bulpros.com   	|password=qwertyuiop1	|7b2f11e4-b035-4cc4-9b70-a164ff0efdeb	|DWT-ACTIV-SCS-001|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1	|7b2f11e4-b035-4cc4-9b70-a164ff0efdez	|DWT-ACTIV-ERR-006|	