@smokeTestRWS
Feature: Do checkout
The user is enrolled and want to purchases a product.

#DWT-ESHP-ERR-001.EN	Error retrieving rewards.
#DWT-ESHP-ERR-002.EN	Error adding rewards.
#DWT-ESHP-ERR-003.EN	Unfortunately, you can only use this function, if you are registered with FitMit AOK.
#DWT-ESHP-ERR-004.EN	Your rewards could not be loaded.
#DWT-ESHP-ERR-005.EN	You don't have any rewards in the cart.
#DWT-ESHP-ERR-006.EN	You don't have enough points to buy the rewards in the cart.
#DWT-ESHP-ERR-007.EN	The rewards in the cart could not be loaded.
#DWT-ESHP-ERR-008.EN	Purchase not possible. Please try again later.
#DWT-ESHP-ERR-009.EN	You don't have enough points to buy the rewards in the cart.
#DWT-ESHP-ERR-010.EN	Error retrieving districts.
#DWT-ESHP-ERR-011.EN	Error retrieving categories.
#DWT-ESHP-ERR-012.EN	Error retrieving status partners.
#DWT-ESHP-SCS-001.EN	All products added to the cart.
#DWT-ESHP-SCS-002.EN	Purchase completed. You will receive a shipping confirmation via email.

@Checkout
Scenario Outline: Checkout the products in cart
Given list of products 
When the user logs with her "<username>" and "<password>"
When the user buy "<number>" of "<product>"
Then correct "<responseCode>" is desplayed

Examples:
|username|password			 										|responseCode| 
|userName=automationenr@bulpros.com|password=qwertyuiop1      	|DWT-DATACONTRACT-ERR|
