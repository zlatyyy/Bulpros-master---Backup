@smokeTestAlfrescoSP
Feature: Set permissions

Scenario Outline: Set permissions

When an user send request to setpermissions using specified "<type>"
Then the server returns correct response

Examples: 
|type|
|userdata|
|membershipapps|
|aokcustomers|