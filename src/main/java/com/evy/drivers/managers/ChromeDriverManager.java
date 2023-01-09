package com.evy.drivers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public final class ChromeDriverManager {
    private ChromeDriverManager(){}

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        return new org.openqa.selenium.chrome.ChromeDriver();
    }
}
