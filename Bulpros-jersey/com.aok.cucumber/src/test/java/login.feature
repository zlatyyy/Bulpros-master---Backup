Feature:Login in AOK
 The user wants to be sure that he/she can log in AOK with my account.

#DWT-LGN-ERR-005.EN - Your registration has not been confirmed yet. We have sent you an email with an confirmation link
#DWT-LGN-ERR-001.EN	Login failed. Incorrect username or password.
#DWT-LGN-ERR-002.EN	Login from your IP is currently blocked. Please try again later. !!!Other user registered before 5 min.
#DWT-LGN-ERR-003.EN	Your account has been blocked. Please reset your password. Many incorrect enters. None-enrolled user!
#DWT-LGN-ERR-004.EN	Your account has been blocked or deactivated. Please check your email inbox. In case you did not receive anything, please also check your spam folder. Enrolled user!
#DWT-LGN-SCS-001.EN	Login success.

@smokeTestL
Scenario Outline: Login Functionality
Given the user wants to login
When the user logs in using "<username>" and "<password>"
Then the user should be logged and "<responseCode>" should be correct

Examples:
|username			 					|password				|responseCode| 
|userName=automationpass@bulpros.com   	|password=qwertyuiop1 	|DWT-LGN-SCS-001|
|userName=automationnon@bulpros.com		|password=qwert111111	|DWT-LGN-ERR-001|
|userName=automationenr@bulpros.bbb 	|password=qwertyuiop1	|DWT-LGN-ERR-001|
|userName=automblocked@bulpros.com 		|password=wrong			|DWT-LGN-ERR-004|
|userName=automblocked@bulpros.com   	|password=qwertyuiop1	|DWT-LGN-ERR-003|
|userName=automationemail@bulpros.com  	|password=qwertyuiop1	|DWT-LGN-ERR-005|
