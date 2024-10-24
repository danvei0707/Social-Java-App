package com.campusdual.UtilsDani;

public class Utils {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";  // Reset to default color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String GRAY = "\u001B[90m";
    public static final String YELLOW = "\u001B[33m";

    public static String colorString(String color, String message){
        return color + message + RESET;
    }
}
