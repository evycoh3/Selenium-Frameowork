package com.evy.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.evy.config.ConfigFactory;
import com.evy.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.util.Objects;


public final class ExtentReportManager  {
    private ExtentReportManager() {
    }

    private static ExtentReports extent;

    public static void initReport() {
        if (Objects.isNull(extent)) {
            extent=new ExtentReports();
            extent.setSystemInfo("os.name",System.getProperty("os.name"));
            extent.setSystemInfo("os.arch",System.getProperty("os.arch"));
            extent.setSystemInfo("os.version",System.getProperty("os.version"));
            extent.setSystemInfo("java.version",System.getProperty("java.version"));
            extent.setSystemInfo("user.name",System.getProperty("user.name"));
            extent.setSystemInfo("Browser", String.valueOf(ConfigFactory.getConfig().browser()));
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReport_file_path());
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Tests Reports");
            spark.config().setDocumentTitle("Doc");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport()  {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentTestManager.unload();
        }
        try{
            Desktop.getDesktop().browse(new File(FrameworkConstants.getReport_file_path()).toURI());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createTest(String testName){
        ExtentTest test=extent.createTest(testName);
        ExtentTestManager.set(test);
    }


}
