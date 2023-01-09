package com.evy.pages;

import com.evy.utils.DynamicXpathUtils;
import com.evy.pages.components.MenuBarComponents;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

public final class HomePage extends BasePage {
    MenuBarComponents components;
    public HomePage(){
        components=new MenuBarComponents();
    }


    private HomePage setSide(String menu) {
        var val = DynamicXpathUtils.getXpath(components.getSideMenuBar(), menu);
        click(By.xpath(val), menu);
        return this;
    }

    private HomePage setSubSide(String submenu) {
        var val = DynamicXpathUtils.getXpath(components.getSubSideMenuBar(),submenu);
        click(By.xpath(val), submenu);
        return this;
    }

    @SneakyThrows
    @NonNull
    public <T> T setSideMenuBar(String menu, String submenu, Class<T> cls) {
        setSide(menu);
        setSubSide(submenu);
        return cls.getDeclaredConstructor().newInstance();

    }
}
