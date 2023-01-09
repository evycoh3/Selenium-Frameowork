package com.evy.utils;

import com.evy.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils(){}

    public static String getBase64img(){
        return ((TakesScreenshot) DriverManager.get()).getScreenshotAs(OutputType.BASE64);
    }
}
