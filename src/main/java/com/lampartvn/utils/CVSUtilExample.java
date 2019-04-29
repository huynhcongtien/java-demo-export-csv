package com.lampartvn.utils;

import java.util.Arrays;

public class CVSUtilExample {

    public static void main(String[] args) throws Exception {
        String   csvFile  = "outputs/demo.csv";
        CSVUtils csvUtils = new CSVUtils(csvFile);
        csvUtils.writeLine(Arrays.asList("a", "b", "c", "d"));

        //custom separator + quote
        csvUtils.writeLine(Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');

        //custom separator + quote
        csvUtils.writeLine(Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');

        //double-quotes
        csvUtils.writeLine(Arrays.asList("aaa", "bbb", "cc\"c"));
        csvUtils.saveFile();
    }

}
