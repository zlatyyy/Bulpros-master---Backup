@smokeTestAlfrescoU
Feature: Get alfresco user

Scenario Outline: Get alfresco user

When get the alfresco users with "<userDataNodeRefId>"
Then alfresco users are loaded

Examples:
|userDataNodeRefId|			 								
|cd32e6c8-18ee-4069-ad45-498ed2b6ce69|		
|87dd586f-3fa3-40a2-9757-3da7a078a9d6|