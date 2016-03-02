package com.ikea.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","html:report/smokeTestR.html"}, 
features = {"src/test/java/addSportsActivity.feature","src/test/java/updateLanguage.feature","src/test/java/deactivateAccount.feature",
		"src/test/java/lastActivity.feature","src/test/java/changePassword.feature","src/test/java/addSportsActivity.feature",
		"src/test/java/login.feature","src/test/java/registrationMain.feature","src/test/java/updateCart.feature",
		"src/test/java/registrationForService.feature","src/test/java/getSports.feature","src/test/java/statusLevel.feature",
		"src/test/java/loadCurrentUser.feature","src/test/java/pointBalance.feature","src/test/java/getStatusPartners.feature",
		"src/test/java/pointBalance.feature","src/test/java/getStatusPartnerCategory.feature","src/test/java/getDistricts.feature",
		"src/test/java/getFAQ.feature", "src/test/java/logout.feature","src/test/java/applyForAOKMemberNonLog.feature","src/test/java/getProductCategories.feature",
		"src/test/java/getProducts.feature","src/test/java/termsOfUse.feature","src/test/java/getProducts.feature","src/test/java/alfrescoUsers.feature",
		"src/test/java/alfrescoUpdateRegisteredUsers.feature","src/test/java/alfrescoSetPermission.feature","src/test/java/alfrescoOrderDetails.feature",
		"src/test/java/alfrescoActivityFromNode.feature","src/test/java/alfrescoUsersAndMatchedAOKSystemUsers.feature",
		"src/test/java/alfrescoMatchUsersWithAOKCustomers.feature","src/test/java/getUserCartContent.feature","src/test/java/getCertainProduct.feature",
		"src/test/java/getBonusPartners.feature","src/test/java/getCertainPartner.feature","src/test/java/getTargets.feature","src/test/java/activateUser.feature",
		"src/test/java/getCard.feature","src/test/java/getRoles.feature","src/test/java/forgotPassword.feature","src/test/java/resetPassword.feature",
		"src/test/java/changeUserName.feature","src/test/java/disableUser.feature","src/test/java/updateBeaconActivity.feature","src/test/java/getBeaconSettings.feature",
		"src/test/java/getAllBeacons.feature", "src/test/java/getBeaconCategory.feature","src/test/java/getActivityCategories.feature", "src/test/java/changeAvatar.feature",
		"src/test/java/requestAdminFeedback.feature","src/test/java/userShare.feature"},
tags={"@smokeTestAUs"})
public class RunnerTest {
}