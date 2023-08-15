package com.lsy.ibook.util;

public class StringUtil {
    public static boolean isEmpty(String s){
       /* if(s == null){
            return true;
        }
        if("".equals(s)){
            return true;
        }
        return false;*/

        return s == null ? true : "".equals(s);
    }

    public static boolean isNotEmpty(String s){
        return !isEmpty(s);
    }
}
