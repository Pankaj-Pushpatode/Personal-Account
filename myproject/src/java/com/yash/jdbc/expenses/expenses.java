/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.expenses;

/**
 *
 * @author YASH KUMAR
 */
public class expenses {
   int Exp_id;
   String Exp_ac;
   int Userid;
   int Exp_catid;
   double Amount;
   String Tran_date;
   String Payby;
   String Remark;

    public expenses() {
    }

    public expenses(int Exp_id, String Exp_ac, int Userid, int Exp_catid, double Amount, String Tran_date, String Payby, String Remark) {
        this.Exp_id = Exp_id;
        this.Exp_ac = Exp_ac;
        this.Userid = Userid;
        this.Exp_catid = Exp_catid;
        this.Amount = Amount;
        this.Tran_date = Tran_date;
        this.Payby = Payby;
        this.Remark = Remark;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getExp_ac() {
        return Exp_ac;
    }

    public void setExp_ac(String Exp_ac) {
        this.Exp_ac = Exp_ac;
    }

    public int getExp_catid() {
        return Exp_catid;
    }

    public void setExp_catid(int Exp_catid) {
        this.Exp_catid = Exp_catid;
    }

    public int getExp_id() {
        return Exp_id;
    }

    public void setExp_id(int Exp_id) {
        this.Exp_id = Exp_id;
    }

    public String getPayby() {
        return Payby;
    }

    public void setPayby(String Payby) {
        this.Payby = Payby;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String getTran_date() {
        return Tran_date;
    }

    public void setTran_date(String Tran_date) {
        this.Tran_date = Tran_date;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }



}
