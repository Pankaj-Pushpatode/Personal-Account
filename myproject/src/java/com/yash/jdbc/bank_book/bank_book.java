/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.bank_book;

//import java.util.Date;

/**
 *
 * @author YASH KUMAR
 */
public class bank_book {
     int Acid;
     String Account;
     String Tran_date;
     double Amount;
     int Userid;
     String Operation;
   
    public bank_book() {
    }

    public bank_book(int Acid, String Account, String Tran_date, double amount, int Userid, String Operation) {
        this.Acid = Acid;
        this.Account = Account;
        this.Tran_date = Tran_date;
        this.Amount = amount;
        this.Userid = Userid;
        this.Operation = Operation;
    }

    public String getAccount() {
        return Account;
    }

    public int getAcid() {
        return Acid;
    }

    public double getAmount() {
        return Amount;
    }

    public String getOperation() {
        return Operation;
    }

    public String getTran_date() {
        return Tran_date;
    }

    public int getUserid() {
        return Userid;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public void setAcid(int acid) {
        this.Acid = acid;
    }



    public void setAmount(double amount) {
        this.Amount = amount;
    }

    public void setOperation(String Operation) {
        this.Operation = Operation;
    }

    public void setTran_date(String Tran_date) {
        this.Tran_date = Tran_date;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }





}





