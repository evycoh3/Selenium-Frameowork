package com.evy.pages.components;

import lombok.Getter;
import org.openqa.selenium.By;


public final class LoginComponents {


    @Getter
    private final By email_txt=By.name("login[email]");
    @Getter
    private final By password_txt=By.name("login[password]");

    @Getter
    private final By loginBtn=By.cssSelector("button[type='submit']");





}


