Feature: Get alfresco user together with matched from AOK customers
#KVNR - c39a39ec-7a3c-4649-aa9f-ba9d64effaa0 is userDataNodeRefId for real AOK customer

@smokeTestAlfrescoMU
Scenario Outline: Get alfresco user and matched from AOK customers

When get existing users matching with AOK customers and "<update>"
Then the matched users are returned by server

Examples:
|update|			 								
|true|
|false|