/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abds040.fcitc_spark;


import com.abds040.fcitc_spark.coord.DBTools;
import java.sql.Connection;

/**
 *
 * @author das553
 */
public class FlashCardConstants {
    
    //public static final String LOCAL_PROXY_ADDRESS = "http://localhost:8888";
    public static final String LOCAL_PROXY_ADDRESS = "http://localhost:2002"; 
    
    public static final String REMOTE_LINK_ADDRESS = "https://fcitc.dyndns.info/fcitc/index.jsp";
    
    //public static final String JQuery    = "http://code.jquery.com/jquery-1.8.3.min.js";
    //public static final String JQueryCSS = "http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css";
    //public static final String JQueryMob = "http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js";
    public static final String JQuery    = "js/jquery-1.7.2.min.js";
    //public static final String JQueryCSS = "js/jquery.mobile-1.2.0-alpha.1.min.css";
    //public static final String JQueryMob = "js/jquery.mobile-1.2.0-alpha.1.min.js";
    //public static final String JQuery    = "js/jquery-1.9.1.min.js";
    public static final String JQueryCSS = "js/jquery.mobile-1.3.1.min.css";
    public static final String JQueryMob = "js/jquery.mobile-1.3.1.min.js";
    
    public static final long    TOKEN_TIMEOUT = 24*60*60*1000; 
    public static final long    TIMEOUT_DB_CATS_FCSTATDATE = 30*60*1000; // 30 Minuten
    public static final String  PWCHECK_DB_CATS_FCSTATDATE = "PizzaMan"; 
    
    public static final String FCITC_AJAX_TITLE = "FCitC 0.1r";
    
    public static final String DB_USER       = "APP.USERS";
    public static final String DB_USER_USER  = "username";
    public static final int    DB_USER_USER_min = 4;
    public static final int    DB_USER_USER_max = 50;
    public static final String DB_USER_PASS  = "password";
    public static final int    DB_USER_PASS_min = 4;
    public static final int    DB_USER_PASS_max = 50;
    public static final String DB_USER_REGS  = "regstring";

    public static final String DB_CATS          = "APP.CATEGORIES";
    public static final String DB_CATS_USERNAME = "username";
    public static final String DB_CATS_CATID    = "catid";
    public static final String DB_CATS_CATNAME  = "catname";
    public static final int    DB_CATS_CATNAME_min = 4;
    public static final int    DB_CATS_CATNAME_max = 50;
    public static final String DB_CATS_CATDESC  = "catdesc";
    public static final int    DB_CATS_CATDESC_min = 0;
    public static final int    DB_CATS_CATDESC_max = 200;
    public static final String DB_CATS_DATEADDED  = "dateadded";
    public static final String DB_CATS_FCLISTLO   = "setlistlo";
    public static final String DB_CATS_FCLISTHI   = "setlisthi";
    public static final String DB_CATS_FCLISTSD   = "setlistsd";
    public static final String DB_CATS_FCLISTSO   = "setlistso";
    public static final String DB_CATS_FCLIST =     "fclist";
    public static final String DB_CATS_FCLISTDATE=  "fclistdate";
    public static final String DB_CATS_FCSTATDATE   ="fcstatdate";
    public static final String DB_CATS_FCSTATTOTAL  ="fcstattotal";
    public static final String DB_CATS_FCSTATACTIVE ="fcstatactive";
    public static final String DB_CATS_FCSTATWAITING="fcstatwaiting";
    public static final String DB_CATS_FCSTATLEVEL  ="fcstatlevel";
    public static final String DB_CATS_FCSTATATODO  ="fcstatactivetodo";
    public static final String DB_CATS_FCSTATTTODO  ="fcstattotaltodo";
    public static final String DB_CATS_CATEMAIL     ="catemail";
    public static final String DB_CATS_CATEMAILSORT ="catemailsort";
    public static final String DB_CATS_CATEMAILSIZE ="catemailsize";
    public static final String DB_CATS_CATEMAILDEPTH="catemaildepth";
    
    public static final String DB_CARD          = "APP.CARDS";
    public static final String DB_CARD_CARDID   = "cardid";
    public static final String DB_CARD_USERNAME = "username";
    public static final String DB_CARD_CATID    = "catid";
    public static final String DB_CARD_QUES     = "question";
    public static final int    DB_CARD_QUES_min = 1;
    public static final int    DB_CARD_QUES_max = 200;
    public static final String DB_CARD_ANSW     = "answer";
    public static final int    DB_CARD_ANSW_min = 1;
    public static final int    DB_CARD_ANSW_max = 200;
    public static final String DB_CARD_LEVEL    = "level";
    public static final int    DB_CARD_LEVEL_min= 0;
    public static final int    DB_CARD_LEVEL_max= 500;
    public static final String DB_CARD_PRIO     = "priority";
    public static final int    DB_CARD_PRIO_min = 1;
    public static final int    DB_CARD_PRIO_max = 5;
    public static final String DB_CARD_DATELAST = "datelast";
    public static final String DB_CARD_DATENEXT = "datenext";
    public static final String DB_CARD_ACTIVE   = "active";
    public static final String DB_CARD_TODO     = "todo";
    public static final String DB_CARD_COMMENTS = "comments";
    public static final int    DB_CARD_COMM_min = 0;
    public static final int    DB_CARD_COMM_max = 50;
    public static final String DB_CARD_CARDSTATS = "cardstats";
    
    public static final String DB_STAT01          = "APP.STAT01";
    public static final String DB_STAT01_USERNAME = "username";
    public static final String DB_STAT01_TIMESTAMP= "timestmp";
    public static final String DB_STAT01_SERVICE  = "service";
    public static final String DB_STAT01_DATASIZE = "datasize";
    
    public static final String DB_STAT02          = "APP.STAT02";
    public static final String DB_STAT02_USERNAME = "username";
    public static final String DB_STAT02_CATID    = "catid";
    public static final String DB_STAT02_YYYYMMDD = "yyyymmdd";
    public static final String DB_STAT02_VOCLEVEL = "voclevel";
    public static final String DB_STAT02_TOTAL    = "total";
    public static final String DB_STAT02_ACTIVE   = "active";
    public static final String DB_STAT02_WAITING  = "waiting";
    
    public static final String DB_STAT03          = "APP.STAT03";
    public static final String DB_STAT03_USERNAME = "username";
    public static final String DB_STAT03_CATID    = "catid";
    public static final String DB_STAT03_YYYYMMDD = "yyyymmdd";
    public static final String DB_STAT03_TOTAL    = "total";
    public static final String DB_STAT03_TOTAL_1  = "total_1";
    public static final String DB_STAT03_TOTAL_2  = "total_2";
    public static final String DB_STAT03_TOTAL_3  = "total_3";
    public static final String DB_STAT03_TOTAL_4  = "total_4";
    public static final String DB_STAT03_TOTAL_5  = "total_5";
    
    public static final String VALIDATED_STRING = "OK";
    
    public static final String DBNAME   = "FCDB";
    private static String jdbcName = "jdbc/fcdb";


    public static String getJdbcName() {
        return jdbcName;
    }
    
    public static boolean temp(String temp) {
        try {
            return true;
        } catch (Throwable t) {
            return false;
        } finally {
            
        }
    }
    
    public static boolean tempdb(String temp) {
        Connection conn = null;
        String method = "xxxx.yyyy";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(false);
            
            
            conn.commit();
            return true;
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            //
            //ToDo Message
            return false;
            //
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            //
            
            //
            Logr.exit(method);
        }
    }
}
