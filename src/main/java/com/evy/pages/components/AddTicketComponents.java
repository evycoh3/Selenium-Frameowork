package com.evy.pages.components;

import lombok.Getter;
import org.openqa.selenium.By;

public final class AddTicketComponents {

    @Getter private final By projectName_dropdown= By.id("form_projects_id");
    @Getter private final By department=By.id("tickets_departments_id");
    @Getter private final By type_dropdown=By.id("tickets_tickets_types_id");
    @Getter private final By status_dropdown=By.id("tickets_tickets_status_id");
    @Getter private final By subject_textbox=By.id("tickets_name");
    @Getter private final By description_frame=By.cssSelector(".cke_wysiwyg_frame.cke_reset");
    @Getter private final By description_textbox= By.tagName("p");
    @Getter private final By createdBy_Dropdown=By.id("tickets_users_id");
    @Getter private final By notify_checkbox=By.cssSelector(".checkbox_list label");
    @Getter private final By save_btn=By.cssSelector("button[type='submit']");





}
