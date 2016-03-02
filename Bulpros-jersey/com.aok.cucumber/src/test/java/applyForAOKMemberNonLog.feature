@smokeTestAOKM
Feature: The user can apply for AOK member

#DWT-DATACONTRACT-ERR.EN	Message could not be sent.
#DWT-MEM-ERR-002.EN	Message could not be sent.
#DWT-MEM-ERR-003.EN	Unfortunately, your registration could not be completed. Please try again later.

Scenario Outline: The application for AOK member

Given the user data "<gender>" "<firstName>" "<lastName>" "<postalCode>" "<city>" "<email>" "<birthDate>" "<employmentStatus>" "<address1>"
When this user fills mandatory information
Then the application is sent and "<responseCode>" is correct

Examples:
|gender		|firstName		|lastName	|postalCode	|city	|email				|birthDate					|employmentStatus		|address1		|responseCode|			
|	  		|Simon			|Kocke		|85540		|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|employed				|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|				|Kocke		|85540		|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|selfEmployed			|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|			|85540		|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|student				|Livada 10		|DWT-DATACONTRACT-ERR|
|f			|Simon			|Kocke		|			|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|student				|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|Kocke		|85540		|			|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|student				|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|Kocke		|85540		|München	|					|1985-01-08T00:00:00.000Z	|student				|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|Kocke		|85540		|München	|simonko@gmail.com	|							|student				|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|Kocke		|85540		|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|						|Livada 10		|DWT-DATACONTRACT-ERR|
|m			|Simon			|Kocke		|85540		|München	|simonko@gmail.com	|1985-01-08T00:00:00.000Z	|student				|				|DWT-DATACONTRACT-ERR|
|f			|Loras			|Toorn		|85540		|München	|sirma@gmail.com	|1985-01-08T00:00:00.000Z	|student				|Livada 10		|DWT-MEM-ERR-003|
|f			|Monee			|Choche		|85540		|München	|mone@gmail.com		|1985-01-08T00:00:00.000Z	|employed				|Livada 20		|DWT-MEM-SCS-001|
|f			|Monee			|Choche		|85540		|München	|mone@gmail.com		|1985-01-08T00:00:00.000Z	|employed				|Livada 15		|DWT-MEM-ERR-003|

