@smokeTestRM
Feature: The user wants to register for AOK app

#DWT-REG-SCS-001.EN	Registration successful.
#DWT-REG-ERR-001.EN	Registration failed. Registration in Alfresco failed.
#DWT-REG-ERR-002.EN	Registration failed. Please try again later.
#DWT-REG-ERR-003.EN	Registration failed. Please try again later.
#DWT-REG-ERR-004.EN	Registration failed. Missing or invalid entries.
#DWT-REG-ERR-005.EN	Registration failed. A user with this email address already exists.
#DWT-REG-ERR-006.EN	Registration failed. Please try again.
#DWT-REG-ERR-007.EN	Registration failed. Please try again.
#DWT-REG-ERR-008.EN	Registration failed. Please try again.
#DWT-REG-ERR-009.EN	Registration failed. A user with this email address already exists.
#DWT-REG-ERR-010.EN	Registration failed. A user with this email address already exists.
#DWT-REG-ERR-011.EN	Registration failed. Sending of message failed.
#DWT-REG-ERR-012.EN	Unfortunately, your registration could not be completed. Please try again later.

@registration 
Scenario Outline: The user makes a registration
Given an user enters personal data
When an user fills "<email>" "<username>" "<firstName>" "<secondName>" "<gender>" "<password>"
Then the code "<responseCode>" correct

Examples:
|email							|username						|firstName	|secondName	|gender	|password		|responseCode|
|automationregbulpros.com		|automationreg@bulpros.com		|autoTest	|autoTest	|f		|qwertyuiop1	|DWT-REG-ERR-011|
|automationmainreg@bulpros.com	|automationmainreg@bulpros.com	|			|autoTest	|f		|qwertyuiop1	|DWT-REG-ERR-004|
|automationmainreg@bulpros.com	|automationmainreg@bulpros.com	|autoTest	|			|f		|qwertyuiop1	|DWT-REG-ERR-004|
|automationmainreg@bulpros.com	|automationmainreg@bulpros.com	|autoTest	|autoTest	|f		|				|DWT-REG-ERR-004|
|automationregs@bulpros.com		|automationregs@bulpros.com		|autoTest	|autoTest	|f		|qwertyuiop1	|DWT-REG-ERR-001|
|automationpass@bulpros.com		|automationenr@bulpros.com		|autoTest	|autoTest	|f		|qwertyuiop1	|DWT-REG-ERR-005|
|automationregs@bulpros.com		|automationregs@bulpros.com		|autoTest	|autoTest	|f		|qwertyuiop1	|DWT-REG-ERR-012|