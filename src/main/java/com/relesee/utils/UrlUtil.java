package com.relesee.utils;

public class UrlUtil {
    private static StringBuffer url = new StringBuffer();

    public static String[] splitUrl;

    public static int getLength(){
        return splitUrl.length;
    }

    public static String[] parse(String url, String regex){
        splitUrl = url.split(regex);
        return splitUrl;
    }



}
