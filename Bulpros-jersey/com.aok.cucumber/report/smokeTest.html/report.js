$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/addSportsActivity.feature");
formatter.feature({
  "line": 3,
  "name": "Add sports activity",
  "description": "The user is enrolled and wants to add sports activity.\r\nThe daily/monthly/yearly limit is not reached.\r\nThe approval is automatic.",
  "id": "add-sports-activity",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AddActiviry"
    },
    {
      "line": 2,
      "name": "@smokeTests"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 11,
      "value": "# The reward points amount and status points are 100."
    },
    {
      "line": 12,
      "value": "# The workflow type is automatic."
    },
    {
      "line": 13,
      "value": "# Valid tags Soccer, Sports, Home empty, Social, Membership, Checkup, Jogging, Biking, Fitness"
    }
  ],
  "line": 15,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 16,
  "name": "parameters \"\u003cid\u003e\" \"\u003cname\u003e\" \"\u003ctag\u003e\" for upload photo",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"\u003ctag\u003e\" tag and photo input value for the last activity are correct",
  "keyword": "Then "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;",
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "tag"
      ],
      "line": 22,
      "id": "add-sports-activity;photo-entry-functionality;;1"
    },
    {
      "cells": [
        "a0b595b8-94e8-4908-8582-4546aa185995",
        "Running event",
        "Soccer"
      ],
      "line": 23,
      "id": "add-sports-activity;photo-entry-functionality;;2"
    },
    {
      "cells": [
        "9f2c0e77-d9a0-4d8b-9d8b-d00e61ec5ad7",
        "Cycling event",
        "Jogging"
      ],
      "line": 24,
      "id": "add-sports-activity;photo-entry-functionality;;3"
    },
    {
      "cells": [
        "6413e407-6522-4aef-b343-083f31c28777",
        "Water sports event",
        "Checkup"
      ],
      "line": 25,
      "id": "add-sports-activity;photo-entry-functionality;;4"
    },
    {
      "cells": [
        "f76a6b4d-477f-4568-a00c-bc2bd0569e65",
        "Athletics event",
        "Biking"
      ],
      "line": 26,
      "id": "add-sports-activity;photo-entry-functionality;;5"
    },
    {
      "cells": [
        "2a33d933-3cd7-46e2-a298-b77de206a096",
        "Ball sports event",
        "Fitness"
      ],
      "line": 27,
      "id": "add-sports-activity;photo-entry-functionality;;6"
    },
    {
      "cells": [
        "e97691e1-5a9b-4288-b0c8-bbdbb871b09d",
        "Other sports event",
        "Social"
      ],
      "line": 28,
      "id": "add-sports-activity;photo-entry-functionality;;7"
    },
    {
      "cells": [
        "ec6eeeb3-e158-476e-a2ac-ec87e6312f3e",
        "Sports badge",
        "Soccer"
      ],
      "line": 29,
      "id": "add-sports-activity;photo-entry-functionality;;8"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 485069231,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"a0b595b8-94e8-4908-8582-4546aa185995\" \"Running event\" \"Soccer\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Soccer\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "a0b595b8-94e8-4908-8582-4546aa185995",
      "offset": 12
    },
    {
      "val": "Running event",
      "offset": 51
    },
    {
      "val": "Soccer",
      "offset": 67
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 35852092,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 879547441,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 1995140,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Soccer",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 87950981,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"9f2c0e77-d9a0-4d8b-9d8b-d00e61ec5ad7\" \"Cycling event\" \"Jogging\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Jogging\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "9f2c0e77-d9a0-4d8b-9d8b-d00e61ec5ad7",
      "offset": 12
    },
    {
      "val": "Cycling event",
      "offset": 51
    },
    {
      "val": "Jogging",
      "offset": 67
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 3942099,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 739920376,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 802846,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jogging",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 86057907,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"6413e407-6522-4aef-b343-083f31c28777\" \"Water sports event\" \"Checkup\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Checkup\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "6413e407-6522-4aef-b343-083f31c28777",
      "offset": 12
    },
    {
      "val": "Water sports event",
      "offset": 51
    },
    {
      "val": "Checkup",
      "offset": 72
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 6868666,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 701230385,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 848177,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Checkup",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 89648761,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"f76a6b4d-477f-4568-a00c-bc2bd0569e65\" \"Athletics event\" \"Biking\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Biking\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "f76a6b4d-477f-4568-a00c-bc2bd0569e65",
      "offset": 12
    },
    {
      "val": "Athletics event",
      "offset": 51
    },
    {
      "val": "Biking",
      "offset": 69
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 4414227,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 712803227,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 770914,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Biking",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 85258766,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"2a33d933-3cd7-46e2-a298-b77de206a096\" \"Ball sports event\" \"Fitness\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Fitness\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "2a33d933-3cd7-46e2-a298-b77de206a096",
      "offset": 12
    },
    {
      "val": "Ball sports event",
      "offset": 51
    },
    {
      "val": "Fitness",
      "offset": 71
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 7653836,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 715058096,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 284816,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fitness",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 93626783,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;7",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"e97691e1-5a9b-4288-b0c8-bbdbb871b09d\" \"Other sports event\" \"Social\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Social\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "e97691e1-5a9b-4288-b0c8-bbdbb871b09d",
      "offset": 12
    },
    {
      "val": "Other sports event",
      "offset": 51
    },
    {
      "val": "Social",
      "offset": 72
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 11723377,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 717643111,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 671414,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Social",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.background({
  "line": 8,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 9,
  "name": "I have to authenticate to REST services",
  "keyword": "Given "
});
formatter.match({
  "location": "AddSportsActivity.I_have_to_authenticate_to_REST_services()"
});
formatter.result({
  "duration": 97109869,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Photo entry Functionality",
  "description": "",
  "id": "add-sports-activity;photo-entry-functionality;;8",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@smokeTests"
    },
    {
      "line": 1,
      "name": "@AddActiviry"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "parameters \"ec6eeeb3-e158-476e-a2ac-ec87e6312f3e\" \"Sports badge\" \"Soccer\" for upload photo",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "the user submits entity",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the submit is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "\"Soccer\" tag and photo input value for the last activity are correct",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "ec6eeeb3-e158-476e-a2ac-ec87e6312f3e",
      "offset": 12
    },
    {
      "val": "Sports badge",
      "offset": 51
    },
    {
      "val": "Soccer",
      "offset": 66
    }
  ],
  "location": "AddSportsActivity.parameters_for_upload_photo(String,String,String)"
});
formatter.result({
  "duration": 3943525,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_user_submits_entity()"
});
formatter.result({
  "duration": 812715358,
  "status": "passed"
});
formatter.match({
  "location": "AddSportsActivity.the_submit_is_successful()"
});
formatter.result({
  "duration": 755234,
  "error_message": "org.junit.ComparisonFailure: expected:\u003cDWT-ACTIV-[SCS-001]\u003e but was:\u003cDWT-ACTIV-[ERR-008]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.ikea.cucumber.AddSportsActivity.the_submit_is_successful(AddSportsActivity.java:52)\r\n\tat ✽.Then the submit is successful(src/test/java/addSportsActivity.feature:18)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Soccer",
      "offset": 1
    }
  ],
  "location": "AddSportsActivity.tag_and_photo_input_value_for_the_last_activity_are_correct(String)"
});
formatter.result({
  "status": "skipped"
});
});