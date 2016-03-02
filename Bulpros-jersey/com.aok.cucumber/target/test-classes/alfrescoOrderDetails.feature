@smokeTestAlfrescoOD
Feature: Order details in Alfresco

Scenario Outline: Order details

When an user send request to orderDetails using specified "<orderId>"
Then the server returns a correct response

Examples: 
|orderId|
|1|
|2|
|10|