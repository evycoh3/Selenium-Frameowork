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

public class TaskData {
    @DataProvider(name = "jsonDataProvider")
    public static Object[][] dataProvider() throws Exception {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(FrameworkConstants.getTaskDataFilePath()));
        Type listType = new TypeToken<List<Task>>() {
        }.getType();
        List<Task> testData = gson.fromJson(reader, listType);

        Object[][] data = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i);
        }
        return data;
    }

    public static class Task {
        public String projectName;
        public String type;
        public String name;
        public String status;
        public String priority;
        public String label;
        public String description;
        public String createdBy;
        public ArrayList<String> assignedTo;

    }
}
