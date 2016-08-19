/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abds040.fcitc_spark.coord;

//import com.das553.fcs.FlashCardConstants;
//import com.das553.fcs.db.DBTools;
//import com.das553.fcs.utils.CryptoTools;
//import com.das553.fcs.utils.FCSException;
//import com.das553.fcs.utils.Logr;
//import com.das553.fcs.utils.ReturnCodes;
import com.abds040.fcitc_spark.CryptoTools;
import com.abds040.fcitc_spark.FCSException;
import com.abds040.fcitc_spark.FlashCardConstants;
import com.abds040.fcitc_spark.Logr;
import com.abds040.fcitc_spark.ReturnCodes;
import com.abds040.fcitc_spark._Cache_;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import javax.smartcardio.Card;
//import org.apache.log4j.Category;

/**
 *
 * @author Daniel
 */
public class User {
    private static FlashCardConstants FCC = new FlashCardConstants();
    
    public static boolean testinit() throws FCSException {
        Connection conn = null;
        String method = "User.testinit";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(true);
            
            
            Statement stmt0 = conn.createStatement();
            
            String sql0 = "delete from "+FCC.DB_STAT01+" where "+FCC.DB_STAT01_USERNAME+" like 'test%'";
            Logr.debug(method, sql0);
            int rc0 = stmt0.executeUpdate(sql0);
            Logr.trace(method, "DEL-STATS-test*:rc="+rc0);
            
            Statement stmt1 = conn.createStatement();
            
            String sql1 = "delete from "+FCC.DB_USER+" where "+FCC.DB_USER_USER+" like 'test%'";
            Logr.debug(method, sql1);
            int rc1 = stmt1.executeUpdate(sql1);
            Logr.trace(method, "DEL-USERS-test*:rc="+rc1);
            
            
            return true; // TC100a_UserInitOK
            
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            //
            //ToDo Message
            throw new FCSException(ReturnCodes.TC100z_UserTestInitError); // TC100z_UserTestInitError
            //
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            //
            
            //
            Logr.exit(method);
        }
    }
    
    public static String logon(String username, String password) throws FCSException {
        Connection conn = null;
        String method = "User.logon";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(true);
            
            //User check saves database calls.
            if (!validateUsername(username, null, null)) {
                Logr.debug(method, "TC111d");
                return null; //TC111d_User Login ERR; User invalid
            }
            
            //Passhash check saves database calls.
            if (!validatePasshash(password, null)) {
                Logr.debug(method, "TC111e");
                return null; //TC111e_User Login ERR; Password invalid
            }
            
            String passhash = null;
            try {
                passhash = CryptoTools.getSaltHash(password, username.hashCode()+username);
            } catch (Exception e) {
                Logr.error(method, "TC111c:SaltHash Username="+username);
                return null; // TC111c_User Login ERR: Password wrong (Dont tell user about salt-hash-problem.
            }
            
            Statement stmt1 = conn.createStatement();
            String sql = "select "+FCC.DB_USER_PASS+" from "+FCC.DB_USER+" where "+FCC.DB_USER_USER+"='"+username+"'";
            Logr.debug(method, sql);
            ResultSet rs1 = stmt1.executeQuery(sql);
            if (rs1.next()) {
                if (  (rs1.getString(FCC.DB_USER_PASS).equals(passhash)) 
                        || (rs1.getString(FCC.DB_USER_PASS).equals(""+passhash.hashCode())) 
                        || (rs1.getString(FCC.DB_USER_PASS).equals(password)) ) {
                    Logr.debug(method, "TC111a");
                    return _Cache_.addToken(username); // TC111a_User Logon OK
                } else {
                    Logr.debug(method, "TC111c");
                    return null; // TC111c_User Login ERR: Password wrong 
                }
            } else {
                Logr.debug(method, "TC111b");
                return null; // TC111b_User Login ERR: User unknown
            }
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            //
            //ToDo Message
            throw new FCSException(ReturnCodes.TC111z_LoginError); // TC111z_Unknown Error
            //
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            //
            
            //
            Logr.exit(method);
        }
    }
    
    public static boolean logoff(String username) throws FCSException {
        Connection conn = null;
        String method = "User.logoff";
        try {
            Logr.entry(method);
           
            return _Cache_.delToken(username); // TC114a_User Logonff OK
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            //
            //ToDo Message
            throw new FCSException(ReturnCodes.TC114z_LogoffError); // TC114z_Unknown Error
            //
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            //
            
            //
            Logr.exit(method);
        }
    }
    
     public static int changePassword(String username, String password_old, String password_new) throws FCSException {
        Connection conn = null;
        String method = "User.changePassword";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(true);
            
            //User check saves database calls.
            if (!validateUsername(username, null, null)) {
                Logr.debug(method, "TC120b - User Not Valid");
                return 2; //TC120b
            }
            
            //Passhash check saves database calls. Old Password
            if (!validatePasshash(password_old, null)) {
                Logr.debug(method, ReturnCodes.TC120c_PasswordChangeErrOld);
                return 3;
            }
            //Passhash check saves database calls. New Password
            if (!validatePasshash(password_new, null)) {
                Logr.debug(method, ReturnCodes.TC120d_PasswordChangeErrNew);
                return 4;
            }
            
            String passhash_old = null;
            try {
                passhash_old = CryptoTools.getSaltHash(password_old, username.hashCode()+username);
            } catch (Exception e) {
                Logr.error(method, "TC120y:SaltHash Problems Username="+username);
                return 3;//TC120c_PasswordChangeErrOld
            }
            String passhash_new = null;
            try {
                passhash_new = CryptoTools.getSaltHash(password_new, username.hashCode()+username);
            } catch (Exception e) {
                Logr.error(method, "TC120y:SaltHash Problems Username="+username);
                return 4;//TC120d_PasswordChangeErrNew
            }
            
            Statement stmt1 = conn.createStatement();
            String sql = "select "+FCC.DB_USER_PASS+" from "+FCC.DB_USER+" where "+FCC.DB_USER_USER+"='"+username+"'";
            Logr.debug(method, sql);
            ResultSet rs1 = stmt1.executeQuery(sql);
            boolean password_old_ok = false;
            if (rs1.next()) {
                if (  (rs1.getString(FCC.DB_USER_PASS).equals(passhash_old)) 
                        || (rs1.getString(FCC.DB_USER_PASS).equals(""+passhash_old.hashCode())) 
                        || (rs1.getString(FCC.DB_USER_PASS).equals(password_old)) ) {
                    password_old_ok = true;
                }
            }
            if (!password_old_ok) {
                Logr.debug(method, "Password_old does not match:"+ReturnCodes.TC120c_PasswordChangeErrOld);
                return 3;
            }
            
            Statement stmtu = conn.createStatement();
            StringBuilder sql_u = new StringBuilder();
            sql_u.append("update " + FCC.DB_USER + " ");
            sql_u.append("set "+FCC.DB_USER_PASS+" = '"+passhash_new+"' where "+FCC.DB_USER_USER+"='"+username+"'"); 
            int rc_u = stmtu.executeUpdate(sql_u.toString());
            if (rc_u == 1) {
                Logr.info(method, " Password changed for User '" + username + "':"+ReturnCodes.TC120a_PasswordChangeOK);
                return 1;  // TC120a
            }
            Logr.error(method, "Password not changed for User '" + username + "':"+ReturnCodes.TC120y_PasswordChangeFailed);
            return 999;
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            //
            //ToDo Message
            throw new FCSException(ReturnCodes.TC120z_PasswordChangeError); // TC120z_PasswordChangeError
            //
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            //
            
            //
            Logr.exit(method);
        }
    }
    
    public static boolean register(String username, String password, String email) throws FCSException {
        Connection conn = null;
        String method = "User.register";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(true);
            
            Statement stmt1 = conn.createStatement();
            
            //Username invalid
            validateUsername(username, 
                    ReturnCodes.TC101c_RegisterErrUsernameTS,  // TC101c 
                    ReturnCodes.TC101d_RegisterErrUsernameTL); // TC101d

            //Password invalid
            validatePasshash(password, ReturnCodes.TC101e_RegisterErrPasswordIV); // TC101e
                        
            //Email Tests
            validateEmail(email, ReturnCodes.TC101g_RegisterErrEmailIV); // TC101g
            
            //Username duplicate check
            ResultSet rs_u = stmt1.executeQuery("select * from "+FCC.DB_USER+" where username='"+username+"'");
            if (rs_u == null) { throw new Exception("Error reading from Database"); }
            if (rs_u.next()) {
                throw new FCSException(ReturnCodes.TC101b_RegisterErrUsernameNU); // TC101b
            }
            
            ResultSet rs_e = stmt1.executeQuery("select * from "+FCC.DB_USER+" where email='"+email+"'");
            if (rs_e == null) { throw new Exception("Error reading from Database"); }
            if (rs_e.next()) {
                throw new FCSException(ReturnCodes.TC101f_RegisterErrEmailNU); // TC101f
            }
            
            long timestamp = System.currentTimeMillis();
            
            String passhash = null;
            try {
                //Use hashed username and username as salt for salt-one-way-encryption
                passhash = CryptoTools.getSaltHash(password, username.hashCode() + username);
            } catch (Exception e) {
                Logr.error(method, "TC101e:SaltHash Username=" + username);
                throw new FCSException (ReturnCodes.TC101e_RegisterErrPasswordIV);// TC101e
            }
            
            StringBuilder sql_insert = new StringBuilder();
            sql_insert.append("insert into "+FCC.DB_USER+" values(");
            //sql_insert.append(" '"+username+"','"+passhash+"','"+email+"',");
            sql_insert.append(" ?, ?, ?, ");// '"+username+"','"+passhash+"','"+email+"',");
            sql_insert.append("?, ");//'"+new java.sql.Timestamp(timestamp)+"',"); // DATEREG
            sql_insert.append("?, ");//'"+new java.sql.Timestamp(timestamp)+"',"); // DATEONL
            sql_insert.append("?) ");//REGSTRING
            /*if (username.startsWith("test")) {// REGSTRING
                sql_insert.append("'"+username+"')");
            } else {
                sql_insert.append("'"+timestamp+"')");
            }*/
            
            Logr.debug(method, "Insert String:"+sql_insert.toString());
            
            PreparedStatement pstmt1 = conn.prepareStatement(sql_insert.toString());
            
            //int rc = stmt1.executeUpdate(sql_insert.toString());
            java.sql.Timestamp nowTS = new java.sql.Timestamp(timestamp);
            pstmt1.setString(1, username);
            pstmt1.setString(2, passhash);
            pstmt1.setString(3, email);
            pstmt1.setTimestamp(4, nowTS); //DateREG
            pstmt1.setTimestamp(5, nowTS); //DateONL
            if (username.startsWith("test")) {// REGSTRING
                pstmt1.setString(6, username);
            } else {
                pstmt1.setString(6, timestamp+"");
            }
            int rc = pstmt1.executeUpdate();
            if (rc != 1) {
                Logr.error(method, " User '"+username+"' inserted rc="+rc);
                throw new FCSException(ReturnCodes.TC101z_RegisterError);
            }
            
            //TODO Check status
            //TODO1
            /*
            try {
                String catname1 = "Planets";
                Category.cat_add(username, catname1, catname1+" Demos");
                int catid1=Category.helperCategoryGetIdFromName(username, catname1, conn);
                Card.card_add(username, ""+catid1, "J _ _ _ _ _ R", "J u p i t e r" , true, true, "");
                Card.card_add(username, ""+catid1, "M _ _ S",       "M a r s"       , true, true, "");
                Card.card_add(username, ""+catid1, "V _ _ _ S",     "V e n u s"     , true, true, "");
                Card.card_add(username, ""+catid1, "U _ _ _ _ S",   "U r a n u s"   , true, true, "");
                        
                String catname2 = "Animals";
                Category.cat_add(username, catname2, catname2+" Demos");
                int catid2=Category.helperCategoryGetIdFromName(username, catname2, conn);
                Card.card_add(username, ""+catid2, "D _ G",     "D o g"   , true, true, "");
                Card.card_add(username, ""+catid2, "C _ T",     "C a t"   , true, true, "");
                Card.card_add(username, ""+catid2, "B _ _ D",   "B i r d" , true, true, "");
                Card.card_add(username, ""+catid2, "F _ _ H",   "F i s h" , true, true, "");
                
            } catch (Exception e) {
                //TODO get new Message - throw new FCSException(ReturnCodes.TC101i_RegisterCatError);
                //throw new FCSException(ReturnCodes.TC101z_RegisterError);
                Logr.error(method, "username:"+username+", "+e.getMessage());
                e.printStackTrace();
            }
                    */
            Logr.info(method, " User '" + username + "' inserted rc=" + rc);
            return true;  // TC101a

            
            
        } catch (FCSException f) {
            throw f; // rethrows TC101 Exception
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            throw new FCSException(ReturnCodes.TC101z_RegisterError); // TC101z_Unknown Error
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            Logr.exit(method);
        }
    }
    
    public static boolean validate(String username, String validationstring) throws FCSException {
        Connection conn = null;
        String method = "User.validate";
        try {
            Logr.entry(method);
            conn = DBTools.getConnection();
            conn.setAutoCommit(true);
          
            Statement stmt1 = conn.createStatement();
            Statement stmtu = conn.createStatement();
            
            //SPEEDUP1
            //username String valid?
            if ( (username == null) || (username.length()<FlashCardConstants.DB_USER_USER_min) ) {
                throw new FCSException(ReturnCodes.TC102b_ValidationErrUsernameIV); // TC102b
            }
            //validationstring String valid?
            if ( (validationstring == null) || (validationstring.length()<1) ) {
                throw new FCSException(ReturnCodes.TC102d_ValidationErrStringIV); // TC102d
            }

            //Test ValidatoinString
            String sql1 = "select "+FCC.DB_USER_REGS+" from "+FCC.DB_USER+" where "+FCC.DB_USER_USER+"='"+username+"'";// and "+FCC.DB_USER_REGS+"='"+validationstring+"'";
            ResultSet rs_1 = stmt1.executeQuery(sql1);
            if (rs_1 == null) { throw new Exception("Error reading from Database"); }
            if (rs_1.next()) {
                if (rs_1.getString(FCC.DB_USER_REGS).equalsIgnoreCase(validationstring)) {
                    
                    StringBuilder sql_u = new StringBuilder();
                    sql_u.append("update " + FCC.DB_USER + " ");
                    sql_u.append("set "+FCC.DB_USER_REGS+" = '"+FCC.VALIDATED_STRING+"' where "+FCC.DB_USER_USER+"='"+username+"'"); 

                    int rc = stmtu.executeUpdate(sql_u.toString());
                    if (rc == 1) {
                        Logr.info(method, " User '" + username + "' registered rc=" + rc);
                        return true;  // TC102a
                    }
                    Logr.error(method, " User '" + username + "' registered rc=" + rc);
                    throw new FCSException(ReturnCodes.TC102z_ValidationError);
                } else {
                    if (!rs_1.getString(FCC.DB_USER_REGS).equalsIgnoreCase(FCC.VALIDATED_STRING)) {
                        throw new FCSException(ReturnCodes.TC102e_ValidationErrStringNM); // TC102e
                    } else {
                        throw new FCSException(ReturnCodes.TC102f_ValidationErrAlreadyVal); // TC102f
                    }
                }
            } else {
                throw new FCSException(ReturnCodes.TC102c_ValidationErrUsernameNF); // TC102c
            }
        } catch (FCSException f) {
            throw f; // rethrows TC102 Exception
        } catch (Throwable t) {
            try {
                if (conn != null) {conn.rollback();}
            } catch (Exception e) {}
            Logr.error(method,t.getMessage());
            t.printStackTrace();
            throw new FCSException(ReturnCodes.TC102z_ValidationError); // TC102z_Unknown Error
        } finally {
            if (conn != null) { try {conn.commit();} catch (Exception e) {} }
            if (conn != null) { try {conn.close();} catch (Exception e) {} }
            Logr.exit(method);
        }
    }
    
    
    public static boolean validateUsername(String username, String tooshortmsg, String toolongmsg) throws Exception {
        String method = "User.validateUsername";
        Logr.debug(method, "0001:"+username);
        if ( (username == null) || (username.length() < FlashCardConstants.DB_USER_USER_min) ) {
            Logr.debug(method, "0002");
            if (tooshortmsg == null) return false;
            throw new FCSException(tooshortmsg);
        }
        if (username.length() > FlashCardConstants.DB_USER_USER_max) {
            Logr.debug(method, "0003");
            if (toolongmsg == null) return false;
            throw new FCSException(toolongmsg);
        }
        Logr.debug(method, "0004:OK");
        return true;
    }
    public static boolean validatePasshash(String passhash, String invalidmsg) throws Exception {
        String method = "User.validatePasshash";
        Logr.debug(method, "0001:"+passhash);
        if (passhash == null || passhash.length() < FlashCardConstants.DB_USER_PASS_min) {
            if (invalidmsg == null) return false;
            throw new FCSException(invalidmsg);
        }
        return true;
    }
    public static boolean validateEmail(String email, String invalidmsg) throws Exception {
        if ((email.indexOf("@") > 1) && (email.indexOf("@") < (email.length() - 1))) {
        } else {
            if (invalidmsg == null) return false;
            throw new FCSException(invalidmsg);
        }
        return true;
    }
    
    public static boolean helperUserExists(String username, Connection conn, String usernotfoundmsg) throws Exception {
        String method = "User.helperUserExists";
        String sql1 = "select " + FCC.DB_USER_USER + " from " + FCC.DB_USER + " where " + FCC.DB_USER_USER + "='" + username + "'";
        Logr.debug(method, sql1);
        ResultSet rs1 = conn.createStatement().executeQuery(sql1);
        if (!rs1.next()) {
            if (usernotfoundmsg == null) {
                return false;
            } else {
                throw new FCSException(usernotfoundmsg);
            }
        } else {
            //TODO check for number of cats and product edition and what user paid.
            return true;
        }
    }
}
