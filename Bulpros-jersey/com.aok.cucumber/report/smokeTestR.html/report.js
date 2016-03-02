$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/activateUser.feature");
formatter.feature({
  "line": 2,
  "name": "The user wants to confirm activation via email",
  "description": "",
  "id": "the-user-wants-to-confirm-activation-via-email",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTestZA"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Activate user",
  "description": "",
  "id": "the-user-wants-to-confirm-activation-via-email;activate-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "the user send \"\u003cusername\u003e\" and \"\u003cactivationHash\u003e\" to confirm registration",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the activation is successful",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "the-user-wants-to-confirm-activation-via-email;activate-user;",
  "rows": [
    {
      "cells": [
        "username",
        "activationHash"
      ],
      "line": 10,
      "id": "the-user-wants-to-confirm-activation-via-email;activate-user;;1"
    },
    {
      "cells": [
        "jana.ivova@abv.bg",
        "m7ua7sbs36oimcdbatejulkppu"
      ],
      "line": 11,
      "id": "the-user-wants-to-confirm-activation-via-email;activate-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Activate user",
  "description": "",
  "id": "the-user-wants-to-confirm-activation-via-email;activate-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTestZA"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "the user send \"jana.ivova@abv.bg\" and \"m7ua7sbs36oimcdbatejulkppu\" to confirm registration",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the activation is successful",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "jana.ivova@abv.bg",
      "offset": 15
    },
    {
      "val": "m7ua7sbs36oimcdbatejulkppu",
      "offset": 39
    }
  ],
  "location": "ActivateUser.the_user_send_and_to_confirm_registration(String,String)"
});
formatter.result({
  "duration": 423617566,
  "status": "passed"
});
formatter.match({
  "location": "ActivateUser.the_activation_is_successful()"
});
formatter.result({
  "duration": 4795998,
  "status": "passed"
});
});