/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.cash_book;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author YASH KUMAR
 */
public class cash_bookDao {
    public void create(cash_book bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into cash_book (Account,Tran_date,Amount,Userid,Operation)"
                    + " values(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
          //  pstmt.setInt(1, bean.getAcid());
            pstmt.setString(1, bean.getAccount());
            pstmt.setString(2, bean.getTran_date());
            pstmt.setDouble(3, bean.getAmount());
            pstmt.setInt(4, bean.getUserid());
            pstmt.setString(5, bean.getOperation());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }







    public void edit(cash_book bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update cash_book set "
                    + "Account=?,Tran_date=?,Amount=?,Userid=?,operation=? where Acid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getAccount());
            pstmt.setString(2, bean.getTran_date());
            pstmt.setDouble(3, bean.getAmount());
            pstmt.setInt(4, bean.getUserid());
            pstmt.setString(5, bean.getOperation());
            pstmt.setInt(6, bean.getAcid());
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
            String sql = "delete from cash_book where Acid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record

    public ArrayList<cash_book> findAll() {
        ArrayList<cash_book> al = new ArrayList<cash_book>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from cash_book";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cash_book bean = new cash_book();
                bean.setAcid(rs.getInt("Acid"));
                bean.setAccount(rs.getString("Account"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setOperation(rs.getString("Operation"));
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

      public ArrayList<cash_book> findAllCategorydetailsWise(String details) {
        ArrayList<cash_book> al = new ArrayList<cash_book>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from cash_book" ;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cash_book bean = new cash_book();
                bean.setAcid(rs.getInt("Acid"));
                bean.setAccount(rs.getString("Account"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setOperation(rs.getString("Operation"));
                al.add(bean);
            }
            c.putConnection(conn);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);
        }
        return al;
    }
//Method to fetch selected Record



      public cash_book find(int id) {
        cash_book bean = new cash_book();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from cash_book where  Userid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                bean.setAccount(rs.getString("Account"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setOperation(rs.getString("Operation"));
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }

      public ArrayList<cash_book> findAllDateWise(String sdate,String edate,int userid){
          ArrayList<cash_book> a1=new ArrayList<cash_book>();
          ConnectionPool c=ConnectionPool.getInstance();
          c.initialize();
          Connection conn=c.getConnection();
          try{


              String sql = "Select * from cash_book where tran_date>= '"+ sdate +"'and tran_date <= '" + edate+ "' and userid=" +userid;
               PreparedStatement pstmt=conn.prepareStatement(sql);
               ResultSet rs=pstmt.executeQuery();
               while(rs.next())
               {
                   cash_book bean=new cash_book();
                   bean.setAcid(rs.getInt("Acid"));
                   bean.setAccount(rs.getString("Account"));
                   bean.setTran_date(rs.getString("Tran_date"));
                   bean.setAmount(rs.getDouble("Amount"));
                   bean.setUserid(rs.getInt("Userid"));
                   bean.setOperation(rs.getString("Operation"));
                   a1.add(bean);
                   }

           c.putConnection(conn);
          }
          catch(Exception e)
              {
                   System.out.println("Exceptin" +e);
               }
          finally{
              c.putConnection(conn);
          }
          return a1;


      }

















 public double closingBalance(int useid){

       double db=0;
       ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection conn=c.getConnection();
       try{
         //  String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing_Balance' from dual";
           String sql = "select (SELECT sum(Amount) as total_payment FROM cash_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM cash_book b where userid = ? and operation='pay') as 'Closing Balance' from dual";
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setInt(1, useid);
           pstmt.setInt(2, useid);
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




 public double closingBalanceone(int useid,String sdate,String edate){

       double db=0;
       ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection conn=c.getConnection();
       try{
           //"Select * from bank_book where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid=" +userid;
         //  String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing_Balance' from dual";
           String sql = "select (SELECT sum(Amount) as total_payment FROM cash_book b where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM cash_book b where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid = ? and operation='pay') as 'Closing Balance' from dual";
           PreparedStatement pstmt=conn.prepareStatement(sql);
           pstmt.setInt(1, useid);
           pstmt.setInt(2, useid);

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
















        public String getOptions() {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        String rows = new String();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select Acid,Account,Tran_date,Amount,Userid,Operation from cash_book ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rows += " <option value=" + rs.getInt(1) + "> "
                        + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " +rs.getDouble(4) + "  "+rs.getInt(5) + "  "+rs.getString(6)+ "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            c.putConnection(conn);
        }
        return rows;
    }




        public static void main(String[] args) {
      cash_bookDao cd = new cash_bookDao();

  //  cash_book cb=new cash_book(4,"yash","2015-10-02",1200.0,10,"withdrowal");
 //   cd.create(cb);



  // cd.edit(cb);


//      cd.remove(5);


      /*  ArrayList<cash_book> cb = cd.findAll();
        for (cash_book c : cb) {
        System.out.println(c.getAccount());
        System.out.println(c.getTran_date());
        System.out.println(c.getAmount());
        System.out.println(c.getUserid());
        System.out.println(c.getOperation());
        }
*/

/*        cash_book c=cd.find(10) ;
   System.out.println(c.getAccount());
*/
      /*  ArrayList<cash_book> cb = cd.findAll();
        for (cash_book c : cb) {
        System.out.println(c.getAccount());
        }
*/
/*
        ArrayList<cash_book> a1=cd.findAllDateWise("2015-02-10","2015-12-10",8);
        for(cash_book s:a1){
        System.out.println(s.getAccount());
        System.out.println(s.getAmount());
        System.out.println(s.getTran_date());

*/

  Double db=cd.closingBalanceone(8,"2015-10-03","2015-10-03");
         {
      String s=String.valueOf(db);
      System.out.println(s);
         } 





      // System.out.println(cd.getOptions());
    }

}
