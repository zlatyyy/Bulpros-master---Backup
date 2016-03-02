@smokeTestFgP
Feature: Request a mail to reset the password

Scenario Outline: Request to reset password

When the user logs in with "<username>" and "<password>" and send request with "<email>" to reset password
Then the user receives email for reset

Examples:
|username			 					|password				|email|	
|userName=automationemail@abv.bg   |password=qwertyuiop1		|automationemail@abv.bg|		