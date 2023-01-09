package com.evy.drivers;

import com.evy.drivers.managers.ChromeDriverManager;
import com.evy.drivers.managers.EdgeDriverManager;
import com.evy.drivers.managers.FireFoxDriverManager;
import com.evy.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory(){}
    private static final Map<BrowserType, Supplier<WebDriver>> MAP=new EnumMap<>(BrowserType.class);

    private static final Supplier<WebDriver>CHROME= ChromeDriverManager::getDriver;
    private static final Supplier<WebDriver>FIREFOX= FireFoxDriverManager::getDriver;
    private static final Supplier<WebDriver>EDGE= EdgeDriverManager::getDriver;

    static{
        MAP.put(BrowserType.CHROME,CHROME);
        MAP.put(BrowserType.FIREFOX,FIREFOX);
        MAP.put(BrowserType.EDGE,EDGE);
    }

    public static WebDriver getDriver(BrowserType browserType){
        return MAP.get(browserType).get();
    }



}
