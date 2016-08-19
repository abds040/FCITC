/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abds040.fcitc_spark;

import org.apache.log4j.Logger;



/**
 *
 * @author das553
 */
public class Logr {

    static Logger logger       = org.apache.log4j.Logger.getLogger("stdout_"+System.getProperty("runenv"));
    static Logger loggerstats  = org.apache.log4j.Logger.getLogger("stats_"+System.getProperty("runenv"));
    static Logger loggertrace  = org.apache.log4j.Logger.getLogger("trace_"+System.getProperty("runenv"));
    static Logger loggertrace1 = org.apache.log4j.Logger.getLogger("trace1_"+System.getProperty("runenv"));
    
    //private static File logfile = null;
    //private static FileWriter logwriter = null;

    public static void entry(String class_method) {
        log("TRACE ",class_method, "ENTRY");
        logger.info(class_method+"-ENTRY");
        loggertrace.info(class_method+"-ENTRY");
    }
    public static void exit(String class_method) {
        log("TRACE ",class_method, "EXIT");
        logger.info(class_method+"-EXIT");
        loggertrace.info(class_method+"-EXIT");
    }
    
    public static void debug(String class_method, String message) {
        log("DEBUG ",class_method, message);
        logger.debug(class_method+"-"+message);
        loggertrace.debug(class_method+"-"+message);
    }
    public static void trace(String class_method, String message) {
        log("TRACE ",class_method, message);
        loggertrace.trace(class_method+"-"+message);
    }
    public static void info(String class_method, String message) {
        log("INFO  ",class_method, message);
        logger.info(class_method+"-"+message);
        loggertrace.info(class_method+"-"+message);
    }
    public static void error(String class_method, String message) {
        log("ERROR ",class_method, message);
        logger.error(class_method+"-"+message);
        loggertrace.error(class_method+"-"+message);
    }
    
    public static void trace1(String class_method, String message) {
        //DOMConfigurator.configure("log4j.xml");
        loggertrace1.trace(class_method+"-"+message);
        trace(class_method,message);
    }

    private static void log(String level, String class_method, String message) {
        try {
            System.out.println(new java.util.Date().toString()+
                        " - "+level+" - "+class_method+" - "+message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }
    
    public static void stat(String class_method, long start, long stop) {
        log("STAT  ",class_method, Long.toString(stop-start));
        loggerstats.trace(class_method+"-"+Long.toString(stop-start));
    }
    public static void stat2(String class_method, long start, long stop, String reqsize, int ressize) {
        log("STAT  ",class_method, Long.toString(stop-start)+" - "+reqsize+"/"+ressize);
        loggerstats.trace(class_method+"-"+Long.toString(stop-start)+" - "+reqsize+"/"+ressize);
    }
}
