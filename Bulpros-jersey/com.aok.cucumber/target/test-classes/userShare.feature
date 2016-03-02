@smokeTestURRZ
Feature: The user wants to share certain status level
 
Scenario Outline: Share status level

When this user shares "<statusLevelCode>"
Then the image is shared 

Examples:
|statusLevelCode    |  
|Newbie				|
|Bronze				|
|Silver				|
|Gold				|
|Platinum			|