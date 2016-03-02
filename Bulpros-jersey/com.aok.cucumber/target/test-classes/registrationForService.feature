@smokeTestRS
Feature: The user wants to register for service

#DWT-USR-SCS-001.EN	Get user succeeded.
#DWT-USR-SCS-002.EN	Update user succeeded.
#DWT-USR-SCS-003.EN	Disable user succeeded.
#DWT-USR-SCS-004.EN	Password changed.
#DWT-USR-SCS-005.EN	An email to change your password has been sent to you.
#DWT-USR-SCS-006.EN	Registration for FitMit AOK succeeded.
#DWT-USR-SCS-007.EN	Profile picture changed.
#DWT-USR-SCS-008.EN	Message has been sent.
#DWT-USR-ERR-001.EN	Operation failed. ???Connection error
#DWT-USR-ERR-002.EN	Operation failed. User not found.
#DWT-USR-ERR-003.EN	User operation failed. Alfresco user node not found. ???
#DWT-USR-ERR-004.EN	User operation failed. Alfresco user home folder not found.
#DWT-USR-ERR-005.EN	User operation failed. Alfresco user data node not found. ???
#DWT-USR-ERR-006.EN	Operation failed. Update error.
#DWT-USR-ERR-007.EN	Operation failed. Service unavailable.
#DWT-USR-ERR-008.EN	Operation failed. User not found.
#DWT-USR-ERR-009.EN	User operation failed. Cannot update user in Alfresco.
#DWT-USR-ERR-010.EN	Profile picture could not be changed. Please try again later.
#DWT-USR-ERR-011.EN	Getting the current user failed.
#DWT-USR-ERR-012.EN	Registration failed.
#DWT-USR-ERR-013.EN	Message could not be sent.
#DWT-USR-ERR-014.EN	The user already has Approved Application.
#DWT-USR-ERR-015.EN	An error occurred attempting to retrieve the user.
 
Scenario Outline: Non-enrolled user applies for a service
Given registration data "<email>" "<postalCode>" "<AokInsuranceNumber>" "<limitReached>" "<birthDate>" "<gender>" "<firstName>" "<secondName>" "<street>" "<city>"
When an user logs with "<username>" and "<password>"
When the user fills registration data
Then a "<responseCode>" is correct  

Examples:
|email 				 		|postalCode  	|username							|password	 				|responseCode		|AokInsuranceNumber |limitReached	|birthDate						|firstName		|secondName		|gender	|street		|city|
|automationnon@bulpros.com 	|80000			|userName=autobulpros.com			|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|			|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|		|
|automationnon@bulpros.com 	|8				|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E1234				|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |				|TesterSec		|f		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|80000			|userName=automationnon@bulpros.com|password=qwertyuiop1  		|DWT-USR-ERR-009	|E123456789			|false			|								|TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|delhome@bulpros.com 		|80000			|userName=delhome@bulpros.com		|password=qwertyuiop1  		|DWT-USR-ERR-004	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|deluser@bulpros.com  		|80000			|userName=deluser@bulpros.com		|password=qwertyuiop1  		|DWT-USR-ERR-003	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|abv@bulpros.com  			|80000			|userName=abv@bulpros.com			|password=qwertyuiop1  		|DWT-USR-ERR-002	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|automationnon@bulpros.com 	|11111 			|userName=automationnon@bulpros.com	|password=qwertyuiop1      	|DWT-USR-SCS-006	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|
|automationpass@bulpros.com |10000			|userName=automationpass@bulpros.com|password=qwertyuiop1		|DWT-USR-ERR-014	|E123456789			|false			|1988-01-27T15:46:39.634+01:00  |TesterFir		|TesterSec		|f		|Krakra 3	|Munich	|																															