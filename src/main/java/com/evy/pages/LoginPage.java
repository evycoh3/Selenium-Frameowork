package com.evy.pages;

import com.evy.pages.components.LoginComponents;

public final class LoginPage extends BasePage {
    LoginComponents components;

    public LoginPage() {
        components = new LoginComponents();
    }

    public HomePage loginToApplication(String email, String password) {
        sendKeys(components.getEmail_txt(), email, "email");
        sendKeys(components.getPassword_txt(), password, "password");
        click(components.getLoginBtn(), "loginBtn");
        return new HomePage();
    }
}
