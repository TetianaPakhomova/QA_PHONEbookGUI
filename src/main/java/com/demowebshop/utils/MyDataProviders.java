package com.demowebshop.utils;

import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.*;

public class MyDataProviders {

    @DataProvider(name = "userDataFromCSV")
    public static Iterator<Object[]> userDataFromCSV() {
        List<Object[]> list = new ArrayList<>();
        File file = new File("src/test/resources/ContactData.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                if(split.length < 4) continue;
                list.add(new Object[]{
                        new UserData(split[0], split[1], split[2], split[3])
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list.iterator();
    }

    private record UserData(String string, String string1, String string2, String string3) {
    }
}

