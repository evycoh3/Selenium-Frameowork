package com.evy.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
    private ExtentTestManager(){}

    private static ThreadLocal<ExtentTest>threadLocal=new ThreadLocal<>();

    public static void set(ExtentTest test){
        threadLocal.set(test);
    }
    public static ExtentTest get(){
        return threadLocal.get();
    }
    public static void unload(){
        threadLocal.remove();
    }
}
