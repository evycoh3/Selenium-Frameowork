package com.evy.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.evy.utils.ScreenshotUtils;

public final class ExtentLogger {
    private ExtentLogger(){}


    public static void fail(String msg,boolean screenshotNeeded){
        ExtentTestManager.get().fail(msg, screenshotNeeded ? MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64img()).build() : null);
    }
    public static void skip(String msg,boolean screenshotNeeded){
        ExtentTestManager.get().skip(msg, screenshotNeeded ? MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64img()).build() : null);

    }
    public static void pass(String msg, boolean screenshotNeeded) {
        ExtentTestManager.get().pass(msg, screenshotNeeded ? MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64img()).build() : null);
    }

}
