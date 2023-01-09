package com.evy.converter;

import com.evy.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class BrowserTypeConverter  implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        Map<String,BrowserType>map= Map.of("CHROME",BrowserType.CHROME,
                "FIREFOX",BrowserType.FIREFOX,
                "EDGE",BrowserType.EDGE);
        return map.getOrDefault(browserName.toUpperCase(),BrowserType.CHROME);
    }
}
