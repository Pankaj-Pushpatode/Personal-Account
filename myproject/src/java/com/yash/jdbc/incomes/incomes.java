/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.incomes;

/**
 *
 * @author YASH KUMAR
 */
public class incomes {

   int Inc_id;
   String Inc_ac;
   int Userid;
   int Inc_catid;
   double Amount;
   String Tran_date;
   String Receivby;
   String Remark;

    public incomes() {
    }

    public incomes(int Inc_id, String Inc_ac, int Userid, int Inc_catid, double Amount, String Tran_date, String Receivby, String Remark) {
        this.Inc_id = Inc_id;
        this.Inc_ac = Inc_ac;
        this.Userid = Userid;
        this.Inc_catid = Inc_catid;
        this.Amount = Amount;
        this.Tran_date = Tran_date;
        this.Receivby = Receivby;
        this.Remark = Remark;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getInc_ac() {
        return Inc_ac;
    }

    public void setInc_ac(String Inc_ac) {
        this.Inc_ac = Inc_ac;
    }

    public int getInc_catid() {
        return Inc_catid;
    }

    public void setInc_catid(int Inc_catid) {
        this.Inc_catid = Inc_catid;
    }

    public int getInc_id() {
        return Inc_id;
    }

    public void setInc_id(int Inc_id) {
        this.Inc_id = Inc_id;
    }

    public String getReceivby() {
        return Receivby;
    }

    public void setReceivby(String Receivby) {
        this.Receivby = Receivby;
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
