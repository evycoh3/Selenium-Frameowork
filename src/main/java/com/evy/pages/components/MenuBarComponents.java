package com.evy.pages.components;

import lombok.Getter;

public final class MenuBarComponents {

    @Getter
    private final String sideMenuBar="//*[contains(@class, 'fa')]//following-sibling::span[text()='%value%']";
    @Getter
    private final String subSideMenuBar="//ul[@class='sub-menu']//span[text()='%value%']";


}
