package org.vnvika.travelassistanttelegrambot;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Utils {
    public static String exceptionStackTraceToString(Exception exception){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw.toString();
    }
}
