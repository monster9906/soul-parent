package com.soul.string;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/13-17:58
 */
public class StartEnd {
    public static String input = "As long as tis injustice whenever a\n" +
            "Targathian baby cries out,wherever a distress\n" +
            "signal sounds among the stars ... We'll be three\n";

    private static class Display{
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex){this.regex = regex;}
        void disPlay(String message){
           if(! regexPrinted){
               System.out.println(regex);
               regexPrinted = true;
           }
            System.out.println(message);
        }
    }

    static void examine(String s,String regex){
        Display display = new Display(regex);
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(s);
        while (matcher.find()){
            display.disPlay("find() '"+matcher.group()+"' start = "+matcher.start() +"end = "+matcher.end());
            if(matcher.lookingAt()){
                display.disPlay("lookingAt() start="+matcher.start() +"end = "+matcher.end());
            }
            if(matcher.matches()){
                display.disPlay("matches() start = "+matcher.start() +" end = "+matcher.end());
            }
        }
    }

    public static void main(String[] args) {
        for (String s : input.split("\n")) {
            System.out.println("input: "+s);
            for (String regex: new String[]{"\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"}){
                examine(s,regex);
            }
        }
    }
}
