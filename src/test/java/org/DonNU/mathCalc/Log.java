package org.DonNU.mathCalc;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import org.apache.log4j.Logger;

public class Log extends Logger {

    protected Log(String name) {
        super(name);
    }

    public static void info(String message) {
        String name = getCallerClassName();
        Logger log = Logger.getLogger(name);
        log.info(message);
    }

    private static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String className = stElements[3].getClassName();
        try {
            return Class.forName(className).getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}