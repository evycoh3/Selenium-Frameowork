package com.evy.logger;

import com.evy.enums.LogType;
import com.evy.reports.ExtentLogger;
import com.evy.reports.ExtentTestManager;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public final class FrameworkLogger {
    private FrameworkLogger(){}
    private static Map<LogType,Consumer<String>> MAP=new HashMap<>();
    private static final Consumer<String>PASS=(message)-> ExtentTestManager.get().pass(message);
    private static final Consumer<String>FAIL=(message)->ExtentTestManager.get().fail(message);
    private static final Consumer<String>SKIP=(message)->ExtentTestManager.get().skip(message);
    private static final Consumer<String>INFO=(message)->ExtentTestManager.get().info(message);
    private static final Consumer<String>CONSOLE=(message)-> System.out.println("info-->"+message);
    private static final Consumer<String>EXTENT=(message)->ExtentTestManager.get().fail(message);

    static{
        MAP.put(LogType.PASS,PASS);
        MAP.put(LogType.SKIP,SKIP);
        MAP.put(LogType.FAIL,FAIL);
        MAP.put(LogType.INFO,INFO);
        MAP.put(LogType.EXTENT,EXTENT);
        MAP.put(LogType.CONSOLE,CONSOLE);
    }
    public static void log(LogType logtype,String message){
        MAP.get(logtype).accept(message);
    }
}
