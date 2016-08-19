/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abds040.fcitc_spark;

import java.util.Map;
import java.util.TreeMap;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import sun.misc.BASE64Encoder;


/**
 *
 * @author Daniel
 */
public class _Cache_ {
    private static TreeMap<String, UserTokenItem> userTokenItems = new TreeMap<String, UserTokenItem>();
    private static BASE64Encoder encoder = new BASE64Encoder();

    public static String addToken(String username) {
        //TODO ErrorHandling
        String tokenstring = encoder.encode((username.hashCode()+"Token"+System.currentTimeMillis()).getBytes());
        //Logr.debug("addtoken", username+":"+tokenstring);
        userTokenItems.put(username, new UserTokenItem(tokenstring));
        return tokenstring;
    }
    
    public static String addToken_new(String username, String remoteip) {
        //TODO ErrorHandling
        String tokenstring = encoder.encode(  ((username.hashCode()+"Token"+System.currentTimeMillis()).hashCode()+"").getBytes()   );
        //Logr.debug("addtoken", username+":"+tokenstring);
        userTokenItems.put(username, new UserTokenItem(tokenstring, remoteip));
        return tokenstring;
    }
    
    public static boolean delToken(String username) {
        //TODO ErrorHandling
        //Logr.debug("addtoken", username+":"+tokenstring);
        if (userTokenItems.containsKey(username)) {
            userTokenItems.remove(username);
        }
        return true;
    }

    public static boolean isTokenValid(String username, String tokenstring) {
        try {
            Logr.debug("token001:username:", username+".");
            Logr.debug("token002:tokenstr:", tokenstring+".");
            Logr.debug("token002:tokenhsh:", tokenstring.hashCode()+".");
            Logr.debug("token003", userTokenItems.keySet()+"");
            Logr.debug("token004", userTokenItems.get(username)+"");
            Logr.debug("token005", userTokenItems.get(username).userTokenString+"");
            Logr.debug("token006", userTokenItems.get(username).userTokenDate+"");
            Logr.debug("token007", userTokenItems.get(username).expirationtime+"");
        } catch (Exception e) {
        }
        //TODO ErrorHandling
        if (username == null) return false;
        if (userTokenItems.containsKey(username)) {
            if (userTokenItems.get(username).isTokenValid()) {
                if ( (tokenstring != null) && (userTokenItems.get(username).userTokenString == tokenstring.hashCode()) ) {
                    userTokenItems.get(username).userTokenDate = System.currentTimeMillis();
                    return true;
                }
            } else {
                userTokenItems.remove(username);
            }
        }
        return false;
    }
    
    public static boolean isTokenValid_new(String username, String tokenstring, String remoteip) {
        try {
            Logr.debug("token001", username);
            Logr.debug("token002", tokenstring);
            Logr.debug("token002", tokenstring.hashCode()+"");
            Logr.debug("token003", userTokenItems.keySet()+"");
            Logr.debug("token004", userTokenItems.get(username) + "");
            Logr.debug("token005", userTokenItems.get(username).userTokenString + "");
            Logr.debug("token006", userTokenItems.get(username).userTokenDate + "");
            Logr.debug("token007", userTokenItems.get(username).expirationtime + "");
            //TODO ErrorHandling
            if (username == null) {
                return false;
            }
            if (remoteip == null) {
                return false;
            }
            if (userTokenItems.containsKey(username)) {
                //Is token valid, and does token belong to user
                if (userTokenItems.get(username).isTokenValid(remoteip)) {
                    if ((tokenstring != null) && (userTokenItems.get(username).userTokenString == tokenstring.hashCode())) {
                        userTokenItems.get(username).userTokenDate = System.currentTimeMillis();
                        return true;
                    }
                } else {
                    userTokenItems.remove(username);
                }
            } else {
                // Server revocation - Token with wrong user
                if (userTokenItems.containsValue(tokenstring)) {
                    // Find the token and delete it
                    for (String key : userTokenItems.keySet()) {
                        if (tokenstring.equals(userTokenItems.get(key).userTokenString)) {
                            userTokenItems.remove(key);
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    static class UserTokenItem {
        long expirationtime = FlashCardConstants.TOKEN_TIMEOUT;
        private int    userTokenString = 0;
        private long   userTokenDate   = 0l;
        private int    userTokenIP     = 0;
        
        UserTokenItem(String tokenstring) {
            this.userTokenString = tokenstring.hashCode();
            this.userTokenDate   = System.currentTimeMillis();
        }
        UserTokenItem(String tokenstring, String remoteip) {
            this.userTokenString = tokenstring.hashCode();
            this.userTokenDate   = System.currentTimeMillis();
            this.userTokenIP     = remoteip.hashCode();
        }
        boolean isTokenValid() { 
            return ( (userTokenDate+expirationtime)>System.currentTimeMillis());
        }
        boolean isTokenValid(String remoteip) { 
            return (
                  // Token expiration check 
                  (userTokenDate+expirationtime)>System.currentTimeMillis()
                  && (remoteip != null)
                  // Token verification for remoteip
                  && (remoteip.equals(userTokenIP))
                  );
        }
    }
}

