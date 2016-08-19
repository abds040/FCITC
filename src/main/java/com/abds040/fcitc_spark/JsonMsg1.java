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
    int id;
    String msg;
}
