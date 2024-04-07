package com.horus.yoga.constant;

public class Constant {

    public static <T> String Deleted(T item){
        return String.format("%s deleted", item);
    }

    public static final String SUCCESS = "Success";

    public static final String EmailNotFound = "User Not Found with Email: ";
}
