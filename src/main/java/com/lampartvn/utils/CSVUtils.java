package com.lampartvn.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVUtils {

    private static final char       DEFAULT_SEPARATOR = ',';
    private              String     filePath;
    private static       FileWriter writer;

    public CSVUtils(String filePath) throws IOException {
        this.filePath = filePath;

        File   file    = new File(filePath);
        String dirPath = file.getParentFile().getName();
        File   dir     = new File(dirPath);

        if (!dir.exists()) {
            dir.mkdir();
        }

        writer = new FileWriter(filePath);
    }

    public void saveFile() throws IOException {
        writer.flush();
        writer.close();
    }

    public static void writeLine(List<String> values) throws IOException {
        writeLine(values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(List<String> values, char separators) throws IOException {
        writeLine(values, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCsvFormat(String value) {
        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    public static void writeLine(List<String> values, char separators, char customQuote) throws IOException {
        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCsvFormat(value));
            } else {
                sb.append(customQuote).append(followCsvFormat(value)).append(customQuote);
            }

            first = false;
        }

        sb.append("\n");
        writer.append(sb.toString());
    }

}
