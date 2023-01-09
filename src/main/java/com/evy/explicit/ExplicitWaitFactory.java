package com.evy.explicit;

import com.evy.constants.FrameworkConstants;
import com.evy.drivers.DriverManager;
import com.evy.enums.LogType;
import com.evy.enums.WaitStrategy;
import com.evy.logger.FrameworkLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;



public final class ExplicitWaitFactory {
    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicit(WaitStrategy waitStrategy, By by) {
        switch (waitStrategy) {
            case CLICKABLE:
                return getWait().until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCE:
                return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
            case VISIBLE:
                return getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
            case NONE:
                return DriverManager.get().findElement(by);
            default:
                throw null;
        }

    }




    private static FluentWait<WebDriver> getWait() {
        return new FluentWait<>(DriverManager.get())
                .withTimeout(Duration.ofSeconds(FrameworkConstants.getExplicit_time()))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(FrameworkConstants.getExplicit_milli_sec_time()));
    }

    }



