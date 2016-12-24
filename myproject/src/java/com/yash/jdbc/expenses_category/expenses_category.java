/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.expenses_category;

/**
 *
 * @author YASH KUMAR
 */
public class expenses_category {
    int Exp_catid;
    String Exp_catname;
    String Exp_catdetails;
    int Userid;

    public expenses_category() {
    }

    public expenses_category(int Exp_catid, String Exp_catname, String Exp_catdetails, int Userid) {
        this.Exp_catid = Exp_catid;
        this.Exp_catname = Exp_catname;
        this.Exp_catdetails = Exp_catdetails;
        this.Userid = Userid;
    }

    public String getExp_catdetails() {
        return Exp_catdetails;
    }

    public void setExp_catdetails(String Exp_catdetails) {
        this.Exp_catdetails = Exp_catdetails;
    }

    public int getExp_catid() {
        return Exp_catid;
    }

    public void setExp_catid(int Exp_catid) {
        this.Exp_catid = Exp_catid;
    }

    public String getExp_catname() {
        return Exp_catname;
    }

    public void setExp_catname(String Exp_catname) {
        this.Exp_catname = Exp_catname;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }



}
