package com.soul.string;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * @author Rich_fu
 * @date 2021/3/12
 */
public class ThreadAnalyzer {
    static String threatData = "58.25.82.151@02/10/2021\n"+
            "204.25.82.151@02/10/2021\n"+
            "58.25.82.151@02/10/2021\n"+
            "58.25.82.151@02/11/2021\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)" +
                "@(\\d{2}/\\d{2}/\\d{4})";

        while (scanner.hasNext(pattern)){
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.printf(" Threat on %s from %s\n",ip,date);
        }
    }
}
