@smokeTest
Feature: Add sports activity

#The workflow type is automatic.
#DWT-ACTIV-SCS-001 - Activity has been submitted.
#DWT-ACTIV-ERR-008 - You are still in test mode and cannot collect more than {0} points in total. (1950 - start)
#DWT-ACTIV-ERR-009 - Test mode limit for Status level reached ( 2000-fit )
#DWT-ACTIV-ERR-010 - Invalid activity tag name 
#DWT-ACTIV-ERR-011 - Invalid activity category
#DWT-ACTIV-SCS-002 - {0} activities are successfully submitted. {1} activities are not successfully submitted. {2}
#DWT-ACTIV-ERR-002 - Activity limit was reached. Activity cannot be submitted. 
#DWT-ACTIV-ERR-012 - As long as you are still in test mode, you cannot collect any more points.

@smokeTest
Scenario Outline: Add sports activity
Given parameters "<id>" "<name>" "<tag>" "<group>" for activity	submitted of "<date>"
When the user logs with "<username>" and "<password>"
When the user submits entity
Then the "<responseCode>" is correct
Then "<hasNewAddedActivity>" relevant "<username>" and "<password>" with category "<id>" "<tag>" "<group>" "<name>"

Examples:
|id                                 	|name                |tag        			|group								|date					 |responseCode	   	|hasNewAddedActivity		|username								|password|
|e9b0c506-28f3-4a20-a4f9-186ff54548d4 	|Automation      	 |Soccer    			|Sports activity					|2016-02-16T18:44:43.337Z|DWT-ACTIV-SCS-001	|true						|userName=automationpass@bulpros.com	|password=qwertyuiop1|
|1cc1t									|Cycling event	  	 |Jogging				|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-008	|false						|userName=automationnon@bulpros.com		|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|Water sports event	 |Checkup				|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-009	|false						|userName=automationnon@bulpros.com		|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|Athletics event	 |*	 					|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-010	|false						|userName=automationenr@bulpros.com		|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|*				 	 |Fitness				|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-011	|false						|userName=automationenr@bulpros.com		|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|SmallLimitForCat	 |Soccer				|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-002	|false						|userName=automationpass@bulpros.com	|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|Athletics event	 |SmallLimitForSubCat	|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-002	|false						|userName=automationpass@bulpros.com	|password=qwertyuiop1|
|1cc1c05e-bc37-4e7f-9fad-cf5d85e27		|Sports badge		 |Soccer				|Upload certificate of participation|2016-02-16T18:44:43.337Z|DWT-ACTIV-ERR-012	|false						|userName=automationnon@bulpros.com		|password=qwertyuiop1|
