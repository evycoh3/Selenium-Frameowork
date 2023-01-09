package com.evy.pages.components;

import lombok.Getter;
import org.openqa.selenium.By;



public final class AddTaskComponents {

    @Getter
    private final By projectName_dropdown= By.id("form_projects_id");
    @Getter
    private final By type_dropdown=By.id("tasks_tasks_type_id");
    @Getter
    private final By name_textbox=By.id("tasks_name");
    @Getter
    private final By status_dropdown=By.id("tasks_tasks_status_id");
    @Getter
    private final By priority_dropdown=By.id("tasks_tasks_priority_id");
    @Getter
    private final By label_dropdown=By.id("tasks_tasks_label_id");
    @Getter
    private final By assignTo_checkbox=By.cssSelector(".checkbox_list label");
    @Getter
    private final By description_frame=By.cssSelector(".cke_wysiwyg_frame.cke_reset");
    @Getter
    private final By description_textbox= By.tagName("p");
    @Getter
    private final By createdBy_Dropdown=By.id("tasks_created_by");
    @Getter
    private final By save_btn=By.cssSelector("button[type='submit']");



}
