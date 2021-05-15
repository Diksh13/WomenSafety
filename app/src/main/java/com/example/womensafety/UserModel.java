package com.example.womensafety;

import java.io.Serializable;
public class UserModel implements Serializable {
    private String name, gmob1,gmob2,gemail;
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGmob1() {
        return gmob1;
    }
    public void setGmob1(String gmob1) {
        this.gmob1 = gmob1;
    }
    public String getGmob2() {
        return gmob2;
    }
    public void setGmob2(String gmob2) {
        this.gmob2 = gmob2;
    }
    public String getGemail() {
        return gemail;
    }
    public void setGemail(String gemail) {
        this.gemail = gemail;
    }

}