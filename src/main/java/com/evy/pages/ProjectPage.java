package com.evy.pages;

import com.evy.pages.components.ProjectPageComponents;


public class ProjectPage extends BasePage {

    ProjectPageComponents components;

    public ProjectPage(){
        components=new ProjectPageComponents();
    }

    public boolean isResponseMessageDisplay(){
        return isDisplay(components.getResponseMsg(),"success message ");
    }

}
