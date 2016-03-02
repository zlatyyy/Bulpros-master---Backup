@smokeTestAlfrescoAFN
Feature: Get activity in Alfresco

Scenario Outline: Get activity in Alfresco

When an user send request to activityFromNode using specified "<activityNode>"
Then the server returns the right response

Examples: 
|activityNode|
|6f13c845-5baf-40d9-99dd-1d50fb499e50|
