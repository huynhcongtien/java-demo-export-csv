package com.lampartvn.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CVSUtilExampleModel {

    public static void main(String[] args) throws Exception {
        String csvFile = "output/developer.csv";

        CSVUtils csvUtils = new CSVUtils(csvFile);

        List<Developer> developers = Arrays.asList(
                new Developer("mkyong", new BigDecimal(120500), 32),
                new Developer("zilap", new BigDecimal(150099), 5),
                new Developer("ultraman", new BigDecimal(99999), 99)
        );

        //for header
        csvUtils.writeLine(Arrays.asList("Name", "Salary", "Age"));

        for (Developer d : developers) {

            List<String> list = new ArrayList<>();
            list.add(d.getName());
            list.add(d.getSalary().toString());
            list.add(String.valueOf(d.getAge()));

            CSVUtils.writeLine(list);
        }

        csvUtils.saveFile();
    }

}
