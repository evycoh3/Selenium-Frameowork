package com.evy.config;

import com.evy.converter.BrowserTypeConverter;
import com.evy.enums.BrowserType;
import org.aeonbits.owner.Config;

@Config.Sources("file:${user.dir}/src/main/resources/config.properties")
public interface FrameworkConfig  extends Config {


    @ConverterClass(BrowserTypeConverter.class)
    @DefaultValue("CHROME")
    BrowserType browser();
    String url();

    String email();
    String password();

}
