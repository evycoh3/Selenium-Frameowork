package com.evy.pages;

import com.evy.pages.components.AddTaskComponents;


public class AddTaskPage extends BasePage{
    AddTaskComponents components;
    public AddTaskPage(){
        components=new AddTaskComponents();
    }
    public AddTaskPage setProjectName(String projectName){
        select(components.getProjectName_dropdown(),projectName,"projectName");
        return this;
    }
    public AddTaskPage setType(String taskType){
        select(components.getType_dropdown(),taskType,"taskType");
        return this;
    }
    public AddTaskPage setName(String taskName){
        sendKeys(components.getName_textbox(),taskName,"taskName");
        return this;
    }
    public AddTaskPage setStatus(String taskStatus){
        select(components.getStatus_dropdown(),taskStatus,"taskStatus");
        return this;
    }
    public AddTaskPage setPriority(String taskPriority){
        select(components.getPriority_dropdown(),taskPriority,"taskPriority");
        return this;
    }
    public AddTaskPage setLabel(String taskLabel){
        select(components.getLabel_dropdown(),taskLabel,"taskLabel");
        return this;
    }
    public AddTaskPage setAssignedTo(String...value){
        selectMultipleCheckbox(components.getAssignTo_checkbox(),"taskAssignedTo",value);
        return this;
    }
    public AddTaskPage setDescription(String taskDescription){
        switchToFrame(components.getDescription_frame());
        sendKeys(components.getDescription_textbox(),taskDescription,"taskDescription");
        switchToDefaultContent();
        return this;
    }
    public AddTaskPage setCreatedBy(String taskCreatedBy){
        select(components.getCreatedBy_Dropdown(),taskCreatedBy,"taskCreatedBy");
        return this;
    }
    public ProjectPage clickSaveButton(){
        click(components.getSave_btn(),"task Save Button");
        return new ProjectPage();
    }
}
