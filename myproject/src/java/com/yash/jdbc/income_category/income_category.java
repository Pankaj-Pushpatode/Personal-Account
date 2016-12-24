/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.income_category;

/**
 *
 * @author YASH KUMAR
 */
public class income_category {
    int Inc_catid;
    String Inc_catname;
    String Inc_catdetails;
    int Userid;

    public income_category() {
    }

    public income_category(int Inc_catid, String Inc_catname, String Inc_catdetails, int Userid) {
        this.Inc_catid = Inc_catid;
        this.Inc_catname = Inc_catname;
        this.Inc_catdetails = Inc_catdetails;
        this.Userid = Userid;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }

    public String getInc_catdetails() {
        return Inc_catdetails;
    }

    public void setInc_catdetails(String Inc_catdetails) {
        this.Inc_catdetails = Inc_catdetails;
    }

    public int getInc_catid() {
        return Inc_catid;
    }

    public void setInc_catid(int Inc_catid) {
        this.Inc_catid = Inc_catid;
    }

    public String getInc_catname() {
        return Inc_catname;
    }

    public void setInc_catname(String Inc_catname) {
        this.Inc_catname = Inc_catname;
    }


}
