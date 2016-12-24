/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.expenses;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author YASH KUMAR
 */
public class expensesDao {


    public void create(expenses bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into expenses (Exp_ac,Userid,Exp_catid,Amount,Tran_date,Payby,Remark)"
                    + " values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
          //  pstmt.setInt(1, bean.getAcid());
            pstmt.setString(1, bean.getExp_ac());
            pstmt.setInt(2, bean.getUserid());
            pstmt.setInt(3, bean.getExp_catid());
            pstmt.setDouble(4, bean.getAmount());
            pstmt.setString(5, bean.getTran_date());
            pstmt.setString(6, bean.getPayby());
            pstmt.setString(7, bean.getRemark());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }


      public void edit(expenses bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update expenses set "
                    + "Exp_ac=?,Userid=?,Exp_catid,Amount=?,Tran_date=?,Payby=?,Remark=? where Exp_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, bean.getExp_ac());
            pstmt.setInt(2, bean.getUserid());
            pstmt.setInt(3, bean.getExp_catid());
            pstmt.setDouble(4, bean.getAmount());
            pstmt.setString(5, bean.getTran_date());
            pstmt.setString(6, bean.getPayby());
            pstmt.setString(7, bean.getRemark());
            pstmt.setInt(8, bean.getExp_id());
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
            String sql = "delete from expenses where Exp_id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record


        public ArrayList<expenses> findAll() {
        ArrayList<expenses> al = new ArrayList<expenses>();

        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from expenses";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                expenses bean = new expenses();
                bean.setExp_id(rs.getInt("Exp_id"));
                bean.setExp_ac(rs.getString("Exp_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setPayby(rs.getString("Payby"));
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
//method for findall expenses Categorydetails wise


//Method to Fetch All expenses of a particular user
      public ArrayList<expenses>findAll(int userid){
            ArrayList<expenses> s = new ArrayList<expenses>();

            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection conn=c.getConnection();
           try {
            String sql = "Select * from expenses where  userid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                 expenses bean = new expenses();
                bean.setExp_ac(rs.getString("Exp_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setPayby(rs.getString("Payby"));
                bean.setRemark(rs.getString("Remark"));

 s.add(bean);
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return s;
    }



         public expenses find(int id) {
        expenses bean = new expenses();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from expenses where  Exp_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setExp_ac(rs.getString("Exp_ac"));
                bean.setUserid(rs.getInt("Userid"));
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setAmount(rs.getDouble("Amount"));
                bean.setTran_date(rs.getString("Tran_date"));
                bean.setPayby(rs.getString("Payby"));
                bean.setRemark(rs.getString("Remark"));


            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }




          public double sum(int useid,String sdate,String edate){

       double db=0;
       ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection conn=c.getConnection();
       try{
           //"Select * from bank_book where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid=" +userid;
         //  String sql = "select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing_Balance' from dual";
           String sql = "select (SELECT sum(Amount) as total_payment FROM expenses b where tran_date>= '"+ sdate +  "' and tran_date <= '" + edate+ "' and userid = ?) as 'sum"
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


         public ArrayList<expenses>findAllDateWise(String sdate,String edate,int userid){
             ArrayList<expenses> a1=new ArrayList<expenses>();
             ConnectionPool c=ConnectionPool.getInstance();
             c.initialize();
             Connection conn=c.getConnection();
             try{
             String sql="select * from expenses where tran_date>='"+sdate+"' and tran_date<='"+edate+"'and userid="+userid;
             PreparedStatement pstmt=conn.prepareStatement(sql);
             ResultSet rs=pstmt.executeQuery();
             while(rs.next()){
                 expenses bean=new expenses();
                 bean.setExp_id(rs.getInt("Exp_id"));
                 bean.setExp_ac(rs.getString("Exp_ac"));
                 bean.setTran_date(rs.getString("Tran_date"));
                 bean.setUserid(rs.getInt("Userid"));
                 bean.setExp_catid(rs.getInt("Exp_catid"));
                 bean.setAmount(rs.getDouble("Amount"));
                 bean.setPayby(rs.getString("Payby"));
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
            String sql = "select Exp_id,Exp_ac,Userid,Exp_catid,Amount,Tran_date,Payby,Remark from expenses ";
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
      expensesDao cd = new expensesDao();

 //   expenses cb=new expenses(1,"dj",10,15,1000.0,"2014-02-10","cash","withdrowal");
 //   cd.create(cb);



  // cd.edit(cb);


      //cd.remove(2);


/*        ArrayList<expenses> cb = cd.findAll();
        for (expenses c : cb) {
        System.out.println(c.getExp_ac());
        System.out.println(c.getUserid());

        System.out.println(c.getExp_catid());
        System.out.println(c.getAmount());
        System.out.println(c.getTran_date());           

        System.out.println(c.getPayby());

        System.out.println(c.getRemark());



        }
*/
/*
      expenses c=cd.find(3) ;{
            System.out.println(c.getAmount());
              System.out.println(c.getExp_ac());
                System.out.println(c.getUserid());
                  System.out.println(c.getRemark());
      }
  */

      /*  ArrayList<expenses> cb = cd.findAll();
        for (expenses c : cb) {
        System.out.println(c.getAccount());

*/
/*   ArrayList<expenses> cb=cd.findAll(10);
      for (expenses c : cb) {
    //   System.out.println(c.getExp_ac);
   //     System.out.println(c.getTran_date());
        System.out.println(c.getAmount());
        System.out.println(c.getUserid());
     //   System.out.println(c.getRemark());
        }
  
*/


 ArrayList<expenses> a1=cd.findAllDateWise("2015-02-10","2015-12-10",10);
    for(expenses s:a1){
        System.out.println(s.getExp_ac());
        System.out.println(s.getAmount());
        System.out.println(s.getTran_date());
    }





      // System.out.println(cd.getOptions());
    }

}
