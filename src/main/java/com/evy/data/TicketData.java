package com.evy.data;

import com.evy.constants.FrameworkConstants;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TicketData {
    @DataProvider(name = "jsonDataProvider")
    public static Object[][] dataProvider() throws Exception {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(FrameworkConstants.getTicketDataFilePath()));
        Type listType = new TypeToken<List<TicketData.Ticket>>() {
        }.getType();
        List<TaskData.Task> testData = gson.fromJson(reader, listType);

        Object[][] data = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
        }
        return data;
    }
    public static class Ticket{
        public String projectName;
        public String department;
        public  String type;
        public String status;
        public String subject;
        public String description;
        public String createdBy;
        public ArrayList<String >notifyTo;

    }

}
