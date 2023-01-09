package com.evy.tests;

import com.evy.drivers.Driver;
import com.evy.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
    @BeforeMethod
    public void setup(){
        Driver.initDriver();
    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

}
