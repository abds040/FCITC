/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abds040.fcitc_spark.coord;


import com.abds040.fcitc_spark.FlashCardConstants;
import com.abds040.fcitc_spark.Logr;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NoInitialContextException;
import javax.sql.DataSource;



/**
 *
 * @author das553
 */
public class DBTools {

    public static synchronized Connection getConnection() {
        Connection conn = null;
        String method = "DBTools.getConnection";
        try {
            Logr.entry(method);
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/"+FlashCardConstants.DBNAME+";user=root;password=root");
            if (conn != null) return conn;
            InitialContext ctx = new InitialContext();
            Context envctx = (Context)ctx.lookup("java:/comp/env");
            DataSource ds = (DataSource) envctx.lookup(FlashCardConstants.getJdbcName());
            conn = ds.getConnection();
            return conn;
        } catch (NoInitialContextException e) {
            try {
            // Try to get with properties
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection("jdbc:derby://localhost:2001/"+FlashCardConstants.DBNAME+";user=root;password=root");
            return conn;
            } catch (Exception ce ) {
                Logr.error(method, ce.getMessage());
                e.printStackTrace();
                return null;
            }
        } catch (Throwable me) {
            Logr.error(method, me.getMessage());
            me.printStackTrace();
            return null;
        } finally {
            Logr.exit(method);
        }
        
    }

}
