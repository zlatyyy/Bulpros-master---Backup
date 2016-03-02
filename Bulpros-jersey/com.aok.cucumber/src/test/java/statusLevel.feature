@smokeTestSL
Feature: All available in alfresco status levels are loaded when the user log in to AOK

#DWT-STL-SCS-001.EN	Get status levels succeeded.
#DWT-STL-ERR-001.EN	Status level could not be found.
#DWT-STL-NEWBIE.EN	Start
#DWT-STL-BRONZE.EN	Active
#DWT-STL-SILVER.EN	Fit
#DWT-STL-GOLD.EN	Top
#DWT-STL-PLATINUM.EN Best

Scenario Outline: Load status levels in store

Given defined levels
When the user logs using "<username>" and "<password>"
Then the received response code is correct
|responseCode|DWT-STL-SCS-001|DWT-STL-ERR-001|


Examples:
|username			 					|password|				
|userName=automationpass@bulpros.com   	|password=qwertyuiop1|		
|userName=automationnon@bulpros.com		|password=qwertyuiop1|	
	