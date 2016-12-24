/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.cash_book;

/**
 *
 * @author YASH KUMAR
 */
public class cash_book {
    int Acid;
     String Account;
     String Tran_date;
     double Amount;
     int Userid;
     String Operation;

    public cash_book() {
    }

    public cash_book(int Acid, String Account, String Tran_date, double Amount, int Userid, String Operation) {
        this.Acid = Acid;
        this.Account = Account;
        this.Tran_date = Tran_date;
        this.Amount = Amount;
        this.Userid = Userid;
        this.Operation = Operation;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public int getAcid() {
        return Acid;
    }

    public void setAcid(int Acid) {
        this.Acid = Acid;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String Operation) {
        this.Operation = Operation;
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
