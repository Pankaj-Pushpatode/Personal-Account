/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.income_category;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author YASH KUMAR
 */
public class income_categoryDao {
    public void create(income_category bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into income_category (Inc_catname,Inc_catdetails,Userid)"
                    + " values(?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

           pstmt.setString(1, bean.getInc_catname());
            pstmt.setString(2, bean.getInc_catdetails());
            pstmt.setInt(3, bean.getUserid());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
      public void edit(income_category bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update income_category set "
                    + "Inc_catname=?,Inc_catdetails=?,Userid=? where Inc_catid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, bean.getInc_catname());
            pstmt.setString(2, bean.getInc_catdetails());
            pstmt.setInt(3, bean.getUserid());
            pstmt.setInt(4,bean.getInc_catid());
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
            String sql = "delete from income_category where Inc_catid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record
        public ArrayList<income_category> findAll() {
        ArrayList<income_category> al = new ArrayList<income_category>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from income_category";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                income_category bean = new income_category();
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setInc_catname(rs.getString("Inc_catname"));
                bean.setInc_catdetails(rs.getString("Inc_catdetails"));
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


        public income_category find(int id) {
        income_category bean = new income_category();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from income_category where  Inc_catid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
               // bean.setExp_catid(rs.getInt("Exp_catid"));
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setInc_catname(rs.getString("Inc_catname"));
                bean.setInc_catdetails(rs.getString("Inc_catdetails"));
                bean.setUserid(rs.getInt("Userid"));
            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }

           public ArrayList<income_category>findAll(int userid){
            ArrayList<income_category> s = new ArrayList<income_category>();

            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection conn=c.getConnection();
           try {
            String sql = "Select * from income_category where  userid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                 income_category bean = new income_category();
                bean.setInc_catid(rs.getInt("Inc_catid"));
                bean.setUserid(rs.getInt("Userid"));


                bean.setInc_catname(rs.getString("Inc_catname"));
                bean.setInc_catdetails(rs.getString("Inc_catdetails"));

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
            String sql = "select Inc_catid,Inc_catname,Inc_catdetails,Userid from income_category ";
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
      income_categoryDao cd = new income_categoryDao();

    income_category cb=new income_category(3,"indirect","yearly",8);
    //cd.create(cb);



   //cd.edit(cb);


      //cd.remove(2);


   /*     ArrayList<income_category> cb = cd.findAll();
        for (income_category c : cb) {
        System.out.println(c.getInc_catname());
        System.out.println(c.getInc_catdetails());

        System.out.println(c.getUserid());

        }

*/
      income_category c=cd.find(3) ;
        System.out.println(c.getInc_catname());
        System.out.println(c.getInc_catid());


 /*       ArrayList<income_category> cb = cd.findAll();
        for (income_category c : cb) {
        System.out.println(c.getInc_catname());
        }
*/


      /*     ArrayList<income_category> cb=cd.findAll(10);
      for (income_category c : cb) {
    //   System.out.println(c.getInc_ac);
   //     System.out.println(c.getTran_date());
        System.out.println(c.getInc_catdetails());
        System.out.println(c.getInc_catname());
        System.out.println(c.getInc_catid());
        System.out.println(c.getUserid());
     //   System.out.println(c.getRemark());
        */}



      // System.out.println(cd.getOptions());
    }


