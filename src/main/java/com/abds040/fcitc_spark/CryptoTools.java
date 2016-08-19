/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abds040.fcitc_spark;

import java.security.MessageDigest;

/**
 *
 * @author Daniel Schoeman
 */
public class CryptoTools {

    public static String getSaltHash(String password, String salt) throws Exception {
        String method = "CryptoTools.getSaltHash";
        int hashRepetitions = 17; // Number of times to repeat the hashing.
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.reset();
            messageDigest.update(salt.getBytes());
            byte[] saltedHash = messageDigest.digest(password.getBytes("UTF-8"));
            for (int hashCounter = 0; hashCounter < hashRepetitions; hashCounter++) {
                messageDigest.reset();
                saltedHash = messageDigest.digest(saltedHash);
            }
            return new String(saltedHash);
        } catch (Exception e) {
            e.printStackTrace();
            Logr.error(method, "Salt-Encryption Error:"+e.getMessage());
            throw new Exception("Error with Salt-Hash:"+e.getMessage());
        }
    }
    
}
