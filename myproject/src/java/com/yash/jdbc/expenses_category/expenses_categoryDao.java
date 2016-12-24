/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.expenses_category;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author YASH KUMAR
 */
public class expenses_categoryDao {
     public void create(expenses_category bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into expenses_category (Exp_catname,Exp_catdetails,Userid)"
                    + " values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
          
           pstmt.setString(1, bean.getExp_catname());
            pstmt.setString(2, bean.getExp_catdetails());
            pstmt.setInt(3, bean.getUserid());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }




      public void edit(expenses_category bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update expenses_category set "
                    + "Exp_catname=?,Exp_catdetails=?,Userid=? where Exp_catid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, bean.getExp_catname());
            pstmt.setString(2, bean.getExp_catdetails());
            pstmt.setInt(3, bean.getUserid());
            pstmt.setInt(4,bean.getExp_catid());
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
            String sql = "delete from expenses_category where Exp_catid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record
        public ArrayList<expenses_category> findAll() {
        ArrayList<expenses_category> al = new ArrayList<expenses_category>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from expenses_category";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                expenses_category bean = new expenses_category();
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setExp_catname(rs.getString("Exp_catname"));
                bean.setExp_catdetails(rs.getString("Exp_catdetails"));
                bean.setUserid(rs.getInt("Userid"));
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
        public expenses_category find(int id) {
        expenses_category bean = new expenses_category();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from expenses_category where  Exp_catid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setExp_catname(rs.getString("Exp_catname"));
                bean.setExp_catdetails(rs.getString("Exp_catdetails"));
                bean.setUserid(rs.getInt("Userid"));
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }


           public ArrayList<expenses_category>findAll(int userid){
            ArrayList<expenses_category> s = new ArrayList<expenses_category>();

            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection conn=c.getConnection();
           try {
            String sql = "Select * from expenses_category where  userid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                 expenses_category bean = new expenses_category();
                bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setUserid(rs.getInt("Userid"));


                bean.setExp_catname(rs.getString("Exp_catname"));
                bean.setExp_catdetails(rs.getString("Exp_catdetails"));

               s.add(bean);
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return s;
    }



        public String getOptions() {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        String rows = new String();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select Exp_catid,Exp_catname,Exp_catdetails,Userid from expenses_category ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rows += " <option value=" + rs.getInt(1) + "> "
                        + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " +rs.getDouble(4) + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            c.putConnection(conn);
        }
        return rows;
    }

     public static void main(String[] args) {
      expenses_categoryDao cd = new expenses_categoryDao();

  // expenses_category cb=new expenses_category(19,"tv","tv",8);
 //  cd.create(cb);



  //  cd.edit(cb);


      cd.remove(22);


  /*  ArrayList<expenses_category> cb = cd.findAll(10);
        for (expenses_category c : cb) {
      //  System.out.println(c.getExp_catname());
        System.out.println(c.getExp_catdetails());
       
       // System.out.println(c.getUserid());
       
        }
*/

     /* expenses_category c=cd.find(8) ;
        System.out.println(c.getExp_catname());
        System.out.println(c.getExp_catid());
*/
      /*ArrayList<expenses_category> cb = cd.findAll();
        for (expenses_category b : cb) {
        System.out.println(c.getExp_catname());
        }
*/




/*
           ArrayList<expenses_category> cb=cd.findAll(5);
      for (expenses_category c : cb) {
    //   System.out.println(c.getExp_ac);
   //     System.out.println(c.getTran_date());
        System.out.println(c.getExp_catdetails());
        System.out.println(c.getExp_catname());
        System.out.println(c.getExp_catid());
        System.out.println(c.getUserid());
     //   System.out.println(c.getRemark());

 */
     }






     //  System.out.println(cd.getOptions());
    }




