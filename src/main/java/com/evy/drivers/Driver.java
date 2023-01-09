package com.evy.drivers;

import com.evy.config.ConfigFactory;
import com.evy.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {
    private Driver() {
    }


    public static void initDriver() {
        if (Objects.isNull(DriverManager.get())) {
            DriverManager.set(DriverFactory.getDriver(ConfigFactory.getConfig().browser()));
        }
        DriverManager.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicit_time()));
        DriverManager.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageLoadTime()));
        DriverManager.get().manage().window().maximize();
        DriverManager.get().get(ConfigFactory.getConfig().url());
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.get())) {
            DriverManager.get().quit();
            DriverManager.unload();
        }

    }


}
