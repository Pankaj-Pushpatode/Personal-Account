/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.incomes;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author YASH KUMAR
 */
public class incomesDao {

     public void create(incomes bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into incomes (Inc_ac,Userid,Inc_catid,Amount,Tran_date,Receivby,Remark)"
                    + " values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
          //  pstmt.setInt(1, bean.getAcid());
            pstmt.setString(1, bean.getInc_ac());
            pstmt.setInt(2, bean.getUserid());
            pstmt.setInt(3, bean.getInc_catid());
            pstmt.setDouble(4, bean.getAmount());
            pstmt.setString(5, bean.getTran_date());
            pstmt.setString(6, bean.getReceivby());
            pstmt.setString(7, bean.getRemark());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }


      public void edit(incomes bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update incomes set "
                    + "Inc_ac=?,Userid=?,Inc_catid,Amount=?,Tran_date=?,Receivby=?,Remark=? where Inc_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, bean.getInc_ac());
            pstmt.setInt(2, bean.getUserid());
            pstmt.setInt(3, bean.getInc_catid());
            pstmt.setDouble(4, bean.getAmount());
            pstmt.setString(5, bean.getTran_date());
            pstmt.setString(6, bean.getReceivby());
            pstmt.setString(7, bean.getRemark());
            pstmt.setInt(8, bean.getInc_id());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }


       public void remove(int id) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "delete from incomes where Inc_id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record


        public ArrayList<incomes> findAll() {
        ArrayList<incomes> al = new ArrayList<incomes>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from incomes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                incomes bean = new incomes();
                bean.setInc_id(rs.getInt("Inc_id"));
                bean.setInc_ac(rs.getString("Inc_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setReceivby(rs.getString("Receivby"));
                bean.setRemark(rs.getString("Remark"));




                al.add(bean);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);
        }
        return al;
    }
//method for findall Category Categorydetails wise



         public incomes find(int id) {
        incomes bean = new incomes();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from incomes where  Inc_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setInc_ac(rs.getString("Inc_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setReceivby(rs.getString("Receivby"));
                bean.setRemark(rs.getString("Remark"));


            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }


         public ArrayList<incomes>findAll(int userid){
            ArrayList<incomes> s = new ArrayList<incomes>();

            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection conn=c.getConnection();
           try {
            String sql = "Select * from incomes where  userid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                 incomes bean = new incomes();
                bean.setInc_ac(rs.getString("Inc_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setReceivby(rs.getString("Receivby"));
                bean.setRemark(rs.getString("Remark"));

 s.add(bean);
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return s;
    }




         public double sum(int useid,String sdate,String edate){

       double db=0;
       ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection conn=c.getConnection();
       try{
           //"Select * from bank_book where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid=" +userid;
         //  String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing_Balance' from dual";
           String sql = "select (SELECT sum(Amount) as total_payment FROM incomes b where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid = ?) as 'sum"
                   + "' from dual";
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setInt(1, useid);
          // pstmt.setInt(2, useid);

           ResultSet rs=pstmt.executeQuery();
           ResultSetMetaData rm=rs.getMetaData();
           System.out.println("column="+rm.getColumnClassName(1));
           System.out.println("column="+rm.getColumnCount());

           if(rs.next()){
               db=rs.getInt(1);
           }
           c.putConnection(conn);
       } catch(Exception ex){
           ex.printStackTrace();
       }    finally{
           c.putConnection(conn);
            }
       return db;


  }




















          public ArrayList<incomes>findAllDateWise(String sdate,String edate,int userid){
             ArrayList<incomes> a1=new ArrayList<incomes>();
             ConnectionPool c=ConnectionPool.getInstance();
             c.initialize();
             Connection conn=c.getConnection();
             try{
             String sql="select * from incomes where tran_date>='"+sdate+"' and tran_date<='"+edate+"'and userid="+userid;
             PreparedStatement pstmt=conn.prepareStatement(sql);
             ResultSet rs=pstmt.executeQuery();
             while(rs.next()){
                 incomes bean=new incomes();
                 bean.setInc_id(rs.getInt("Inc_id"));
                 bean.setInc_ac(rs.getString("Inc_ac"));
                 bean.setTran_date(rs.getString("Tran_date"));
                 bean.setUserid(rs.getInt("Userid"));
                 bean.setInc_catid(rs.getInt("Inc_catid"));
                 bean.setAmount(rs.getDouble("Amount"));
                 bean.setReceivby(rs.getString("Receivby"));
                 bean.setRemark(rs.getString("Remark"));

                 a1.add(bean);

             }
             c.putConnection(conn);
             }
             catch(Exception e){
                 System.out.println("Exception"+e);
             }
             finally{
                 c.putConnection(conn);
             }
             return a1;

         }


         public String getOptions() {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        String rows = new String();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select Inc_id,Inc_ac,Userid,Inc_catid,Amount,Tran_date,Receivby,Remark from incomes ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rows += " <option value=" + rs.getInt(1) + "> "
                        + "  " + rs.getString(2) + "  " + rs.getInt(3) + "  " +rs.getInt(4) + "  "+rs.getDouble(5) + "  "+rs.getString(6)+ "  "+rs.getString(7) + "  "+rs.getString(8)+ "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            c.putConnection(conn);
        }
        return rows;
    }


          public static void main(String[] args) {
      incomesDao cd = new incomesDao();

 //   incomes cb=new incomes(2,"dj",10,15,1200.0,"2015-06-04","cash","withdrowal");
  //  cd.create(cb);



  // cd.edit(cb);


   //  cd.remove(1);


 /*       ArrayList<incomes> cb = cd.findAll();
        for (incomes c : cb) {
        System.out.println(c.getAccount());
        System.out.println(c.getTran_date());
        System.out.println(c.getAmount());
        System.out.println(c.getUserid());
        System.out.println(c.getOperation());
        }
*/

//        incomes c=cd.find(3) ;
//        System.out.println(c.getAccount());

      /*  ArrayList<incomes> cb = cd.findAll();
        for (incomes c : cb) {
        System.out.println(c.getAccount());
        }
*/


        Double db=cd.sum(8,"2015-10-05","2015-11-01");
         {
      String s=String.valueOf(db);
      System.out.println(s);
         }


    /* ArrayList<incomes> cb=cd.findAll(10);
      for (incomes c : cb) {
    //   System.out.println(c.getExp_ac);
   //     System.out.println(c.getTran_date());
        System.out.println(c.getAmount());
        System.out.println(c.getUserid());
     //   System.out.println(c.getRemark());
        }


*/
 /*   ArrayList<incomes> a1=cd.findAllDateWise("2015-02-10","2015-12-10",10);
    for(incomes s:a1){
        System.out.println(s.getInc_ac());
        System.out.println(s.getAmount());
        System.out.println(s.getTran_date());
    }
*/





     //  System.out.println(cd.getOptions());
    }

}
