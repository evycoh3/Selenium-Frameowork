package com.evy.utils;

public final class DynamicXpathUtils {
    private DynamicXpathUtils(){}

    public static String getXpath(String xpath,String value){
        String val=xpath.replace("%value%",value);
        return val;
    }
}
