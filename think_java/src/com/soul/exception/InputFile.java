package com.soul.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/16-17:24
 */
public class InputFile {
    private BufferedReader in;
    public InputFile(String fileName) throws Exception{
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("文件不能打开"+fileName);
            e.printStackTrace();
        }catch (Exception e){
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() unseccessful");
            }
            throw e;
        }finally {
            // 不能在此处关闭
        }
    }

    public String getLine(){
        String s;
        try {
            s= in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose(){
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}

class CleanUp {
    public static void main(String[] args) {
        try {
            InputFile inputFile = new InputFile("CleanUp.java");
            try {
                String s;
                int i = 1;
                while ((s= inputFile.getLine()) != null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally {
                inputFile.dispose();
            }
        } catch (Exception e) {
            System.out.println("Input construction failed ");
            e.printStackTrace();
        }
    }
}
