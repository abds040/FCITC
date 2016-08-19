/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abds040.fcitc_spark;

/**
 *
 * @author Daniel
 */
public class JsonMsg1 {
    
    int id;
    String msg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    String username;
    String password;

    public JsonMsg1() {
        
    }
    public JsonMsg1(int id, String msg) {
        this.id = id; 
        this.msg = msg;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
