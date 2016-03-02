Feature: Get alfresco user together with matched from AOK system user
#KVNR-c39a39ec-7a3c-4649-aa9f-ba9d64effaa0 is userDataNodeRefId for real AOK customer

@smokeTestAlfrescoUAOKU
Scenario Outline: Get alfresco user and matched from AOK system user

When we get the alfresco user with "<userDataNodeRefId>"
Then alfresco user matched from AOK system user is loaded

Examples:
|userDataNodeRefId|			 								
|cd32e6c8-18ee-4069-ad45-498ed2b6ce69|
|c39a39ec-7a3c-4649-aa9f-ba9d64effaa0|