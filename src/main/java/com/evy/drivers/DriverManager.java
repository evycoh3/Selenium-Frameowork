package com.evy.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){}

    private static ThreadLocal<WebDriver>threadLocal=new ThreadLocal<>();
    public static WebDriver get(){
        return threadLocal.get();
    }
    public static void set(WebDriver driver){
        threadLocal.set(driver);
    }
    public static void unload(){
        threadLocal.remove();
    }
}
