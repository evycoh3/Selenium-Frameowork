package com.evy.drivers.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public final class EdgeDriverManager {

    private EdgeDriverManager(){}

    public static WebDriver getDriver(){
        WebDriverManager.edgedriver().setup();
        return new org.openqa.selenium.edge.EdgeDriver();
    }
}
