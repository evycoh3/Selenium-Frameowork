package com.evy.constants;

import lombok.Getter;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    @Getter
    private static final int explicit_time=15;
    @Getter
    private static final int implicit_time=10;
    @Getter
    private static final int pageLoadTime=10;
    @Getter
    private static final int explicit_milli_sec_time=150;
    @Getter
    private static final String report_file_path=System.getProperty("user.dir")+"/tests-outputs/report.html";
    @Getter private static final String taskDataFilePath=System.getProperty("user.dir") + "/src/main/resources/AddTask,.json";
    @Getter private static final String ticketDataFilePath=System.getProperty("user.dir")+"/src/main/resources/AddTicket.json";
    @Getter private static final String discussionFilePath=System.getProperty("user.dir")+"/src/main/resources/AddDiscussion.json";
}
