package com.soul.container;

import java.util.Map;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/8-14:44
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry<String, String> stringEntry : System.getenv().entrySet()) {
            System.out.println(stringEntry.getKey()+": "+stringEntry.getValue());
        }
    }
}
