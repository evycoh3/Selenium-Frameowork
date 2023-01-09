package com.evy.pages;

import com.evy.pages.components.AddTicketComponents;

public class AddTicketPage extends BasePage {
   AddTicketComponents components;
    public AddTicketPage(){
        components=new AddTicketComponents();
    }
    public AddTicketPage setProjectName(String projectName){
        sendKeys(components.getProjectName_dropdown(),projectName,"projectName");
        return this;
    }
    public AddTicketPage setDepartment(String department){
        select(components.getDepartment(),department,"department");
        return this;
    }
    public AddTicketPage setType(String type){
        select(components.getType_dropdown(),type,"type");
        return this;
    }
    public AddTicketPage setStatus(String status){
        select(components.getStatus_dropdown(),status,"status");
        return this;
    }
    public AddTicketPage setSubject(String subject){
        sendKeys(components.getSubject_textbox(),subject,"subject");
        return this;
    }
    public  AddTicketPage setDescription(String description){
        switchToFrame(components.getDescription_frame());
        sendKeys(components.getDescription_textbox(),description,"description");
        switchToDefaultContent();
        return this;
    }
    public AddTicketPage setCreatedBy(String createdBy){
        select(components.getCreatedBy_Dropdown(),createdBy,"createdBy");
        return this;
    }
    public AddTicketPage setNotify(String ...value){
        selectMultipleCheckbox(components.getNotify_checkbox(),"notify",value);
        return this;
    }
    public ProjectPage clickSaveBtn(){
        click(components.getSave_btn(),"save btn");
        return new ProjectPage();
    }

}
