package com.evy.tests;

import com.evy.config.ConfigFactory;
import com.evy.data.TicketData;
import com.evy.listeners.ListenerClass;
import com.evy.pages.AddTicketPage;
import com.evy.pages.HomePage;
import com.evy.pages.LoginPage;
import com.evy.data.TaskData;
import com.evy.pages.ProjectPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class AddTicketTest extends BaseTest {

    @Test(dataProviderClass = TicketData.class, dataProvider = "jsonDataProvider")
    public void tc_addTicket(TicketData.Ticket ticket) {
        HomePage homePage = new LoginPage().loginToApplication(ConfigFactory.getConfig().email(), ConfigFactory.getConfig().password());
        AddTicketPage addTicketPage = homePage.setSideMenuBar("Tickets", "Add Ticket", AddTicketPage.class);
        ProjectPage projectPage = addTicketPage
                .setProjectName(ticket.projectName)
                .setDepartment(ticket.department)
                .setType(ticket.type)
                .setStatus(ticket.status)
                .setSubject(ticket.subject)
                .setDescription(ticket.description)
                .setCreatedBy(ticket.createdBy)
                .setNotify(ticket.notifyTo.get(0), ticket.notifyTo.get(1))
                .clickSaveBtn();
        Assert.assertTrue(projectPage.isResponseMessageDisplay());


    }
}
