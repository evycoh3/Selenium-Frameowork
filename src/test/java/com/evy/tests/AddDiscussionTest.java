package com.evy.tests;

import com.evy.config.ConfigFactory;
import com.evy.data.DiscussionData;
import com.evy.listeners.ListenerClass;
import com.evy.pages.HomePage;
import com.evy.pages.LoginPage;
import com.evy.pages.ProjectPage;
import com.evy.pages.AddDiscussionPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class AddDiscussionTest extends BaseTest {

    @Test(dataProviderClass = DiscussionData.class, dataProvider = "jsonDataProvider")
    public void tc_addDiscussion(DiscussionData.Discussion discussion) {
        HomePage homePage = new LoginPage().loginToApplication(ConfigFactory.getConfig().email(), ConfigFactory.getConfig().password());
        AddDiscussionPage addDiscussionPage = homePage.setSideMenuBar("Discussions", "Add Discussion", AddDiscussionPage.class);
        ProjectPage projectPage = addDiscussionPage
                .setProjectName(discussion.projectName)
                .setStatus(discussion.status)
                .setAssignedTo(discussion.assignedTo.get(0), discussion.assignedTo.get(1))
                .setName(discussion.name)
                .setDescription(discussion.description)
                .clickSaveBtn();
        Assert.assertTrue(projectPage.isResponseMessageDisplay());
    }
}
