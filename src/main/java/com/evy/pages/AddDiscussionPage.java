package com.evy.pages;

import com.evy.pages.components.AddDiscussionComponents;

public class AddDiscussionPage extends BasePage {
    AddDiscussionComponents components;

    public AddDiscussionPage(){
        components=new AddDiscussionComponents();
    }
    public AddDiscussionPage setProjectName(String projectName){
        select(components.getProjectName_dropdown(),projectName,"projectName");
        return this;
    }
    public AddDiscussionPage setStatus(String status){
        select(components.getStatus_dropdown(),status,"status");
        return this;
    }
    public AddDiscussionPage setAssignedTo(String ...value){
        selectMultipleCheckbox(components.getAssignTo_checkbox(),"assignedTo",value);
        return this;
    }
    public AddDiscussionPage setName(String name){
        sendKeys(components.getName_textbox(),name,"discussion name");
        return this;
    }
    public AddDiscussionPage setDescription(String description){
        switchToFrame(components.getDescription_frame());
        sendKeys(components.getDescription_textbox(),description,"description");
        switchToDefaultContent();
        return this;
    }
    public AddDiscussionPage setCreatedBy(String createdBy){
        select(components.getCreatedBy_dropdown(),createdBy,"createdBy");
        return this;
    }
    public ProjectPage clickSaveBtn(){
        click(components.getSave_btn(),"save btn");
        return new ProjectPage();
    }
}
