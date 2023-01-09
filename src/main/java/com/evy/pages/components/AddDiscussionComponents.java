package com.evy.pages.components;

import lombok.Getter;
import org.openqa.selenium.By;

public final class AddDiscussionComponents {

    @Getter
    private final By projectName_dropdown = By.id("form_projects_id");
    @Getter
    private final By status_dropdown = By.id("discussions_discussions_status_id");
    @Getter
    private final By assignTo_checkbox = By.cssSelector(".checkbox_list label");
    @Getter
    final By name_textbox=By.id("discussions_name");
    @Getter
    private  final By createdBy_dropdown=By.id("discussions_users_id");
    @Getter
    private final By save_btn=By.cssSelector("button[type='submit']");
    @Getter
    private final By description_frame=By.cssSelector(".cke_wysiwyg_frame.cke_reset");
    @Getter
    private final By description_textbox= By.tagName("p");

}
