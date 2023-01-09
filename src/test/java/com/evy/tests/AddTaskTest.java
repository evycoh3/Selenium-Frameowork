package com.evy.tests;


import com.evy.config.ConfigFactory;
import com.evy.listeners.ListenerClass;
import com.evy.pages.AddTaskPage;
import com.evy.pages.HomePage;
import com.evy.pages.LoginPage;
import com.evy.pages.ProjectPage;
import com.evy.data.TaskData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



public class AddTaskTest extends BaseTest {


    @Test(dataProviderClass = TaskData.class,dataProvider = "jsonDataProvider")
    public void tc_addTask(TaskData.Task task) {
        HomePage homePage = new LoginPage().loginToApplication(ConfigFactory.getConfig().email(), ConfigFactory.getConfig().password());
        AddTaskPage addTaskPage = homePage.setSideMenuBar("Tasks", "Add Task", AddTaskPage.class);
        ProjectPage projectPage=  addTaskPage
                .setProjectName(task.projectName)
                .setType(task.type)
                .setName(task.name)
                .setStatus(task.status)
                .setPriority(task.priority)
                .setLabel(task.label)
                .setAssignedTo(task.assignedTo.get(0),task.assignedTo.get(1))
                .setDescription(task.description)
                .setCreatedBy(task.createdBy)
                .clickSaveButton();
        Assert.assertTrue(projectPage.isResponseMessageDisplay());


    }

}
