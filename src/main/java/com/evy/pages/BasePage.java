package com.evy.pages;

import com.evy.drivers.DriverManager;
import com.evy.enums.LogType;
import com.evy.enums.WaitStrategy;
import com.evy.explicit.ExplicitWaitFactory;
import com.evy.logger.FrameworkLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class BasePage {

    protected void sendKeys(By by, String value, String fieldName) {
        try {
            ExplicitWaitFactory.performExplicit(WaitStrategy.PRESENCE, by).sendKeys(value);
            FrameworkLogger.log(LogType.INFO,"send keys to " + fieldName + ":" + value);
        } catch (Exception e) {
           FrameworkLogger.log(LogType.INFO,"Failed to send Keys to " + fieldName + ":" + e.getMessage());
        }
    }

    protected void click(By by, String fieldName) {
        try {
            ExplicitWaitFactory.performExplicit(WaitStrategy.CLICKABLE, by).click();
            FrameworkLogger.log(LogType.INFO,"click on " + fieldName);
        } catch (Exception e) {
            FrameworkLogger.log(LogType.INFO,"Failed to click on " + fieldName + ":" + e.getMessage());
        }
    }

    protected void select(By by, String visibleText, String fieldName) {
        try {
            Select select = new Select(ExplicitWaitFactory.performExplicit(WaitStrategy.CLICKABLE, by));
            select.selectByVisibleText(visibleText);
            FrameworkLogger.log(LogType.INFO,"Select " + visibleText + " from " + fieldName + " dropdown");
        } catch (Exception e) {
            FrameworkLogger.log(LogType.INFO,"Failed to select " + visibleText + " from " + fieldName + " dropdown" + ":" + e.getMessage());
        }
    }

    protected void selectMultipleCheckbox(By by, String fieldName, String... value) {
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            List<WebElement> elements = DriverManager.get().findElements(by);
            boolean selectAll = value[0].equalsIgnoreCase("all");
            for (WebElement element : elements) {
                String str = element.getText();
                boolean shouldSelect = selectAll;
                if (!shouldSelect) {
                    for (String val : value) {
                        if (val.equalsIgnoreCase(str)) {
                            shouldSelect = true;
                            arrayList.add(str);
                            break;
                        }
                    }
                }
                if (shouldSelect) {
                    element.click();
                }
            }
            FrameworkLogger.log(LogType.INFO,"Select from "+fieldName+" dropdown "+String.valueOf(arrayList));
        } catch (Exception e) {
            FrameworkLogger.log(LogType.INFO,"Failed to select " + value + "from " + fieldName + " dropdown " + ":" + e.getMessage());
        }
    }

    protected void switchToFrame(By by) {
        try {
            DriverManager.get().switchTo().frame(DriverManager.get().findElement(by));
            FrameworkLogger.log(LogType.INFO,"switch to frame");
        } catch (Exception e) {
           FrameworkLogger.log(LogType.INFO,"Failed to switch to " + DriverManager.get().findElement(by).getAccessibleName() + ":" + e.getMessage());
        }
    }

    protected void switchToDefaultContent() {
        try {
            DriverManager.get().switchTo().defaultContent();
            FrameworkLogger.log(LogType.INFO,"Switch to default content");
        } catch (Exception e) {
           FrameworkLogger.log(LogType.INFO,"Failed to switch to default content " + e.getMessage());
        }
    }

    protected boolean isDisplay(By by, String fieldName) {
        try {
            ExplicitWaitFactory.performExplicit(WaitStrategy.VISIBLE, by).isDisplayed();
            FrameworkLogger.log(LogType.INFO,fieldName + " is Displayed");
            return true;
        } catch (Exception e) {
           FrameworkLogger.log(LogType.INFO,fieldName + " is Not Displayed");
            return false;
        }


    }
}