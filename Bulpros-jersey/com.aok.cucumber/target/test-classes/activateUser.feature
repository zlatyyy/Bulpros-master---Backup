@smokeTestAUs
Feature: The user wants to confirm activation via email
 
Scenario Outline: Activate user

When the user send "<username>" and "<activationHash>" to confirm registration
Then the activation is successful

Examples:
|username    			|activationHash|
|jana.ivova@abv.bg		|m7ua7sbs36oimcdbatejulkppu|
