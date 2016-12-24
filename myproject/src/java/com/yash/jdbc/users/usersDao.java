/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.yash.jdbc.users;
import com.yash.jdbc.utilities.*;
import java.sql.*;
import java.util.ArrayList;
import org.apache.jasper.tagplugins.jstl.core.Catch;

/**
 *
 * @author YASH KUMAR
 */
public class usersDao {

    public void create(users bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into users (Username,Password,Name,Address,Mobile,Email)"
                    + " values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
          //  pstmt.setInt(1, bean.getAcid());
            pstmt.setString(1, bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }

    public void edit(users bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update users set "
                    + "Username=?,Password=?,Name=?,Address=?,Mobile=?,Email=? where Uid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7, bean.getUid());
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
            String sql = "delete from users where Uid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
    }
//Method to Fetch all Record

    public ArrayList<users> findAll() {
        ArrayList<users> al = new ArrayList<users>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users bean = new users();
                bean.setUid(rs.getInt("Uid"));
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setAddress(rs.getString("Address"));
                bean.setMobile(rs.getString("Mobile"));
                bean.setEmail(rs.getString("Email"));




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

     public users find(int id) {
        users bean = new users();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from users where  Uid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bean.setUsername(rs.getString("Username"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setAddress(rs.getString("Address"));
                bean.setMobile(rs.getString("Mobile"));
                bean.setEmail(rs.getString("Email"));

            }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }

     public int checkAvailablity(String uname){
      //   users bean=new users();
          int st = 0;
        // String s=new String();
         ConnectionPool c=ConnectionPool.getInstance();
         c.initialize();
         Connection conn=c.getConnection();
         try
         {
             String sql="select * from users where Username=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
           if(rs.next())
           {
               return 1;

           }
        } catch (Exception ex) {
        } finally {
            c.putConnection(conn);
        }
                 return st;
         }


     public int checkAvailablity(String uname,String pwd){
         int st=0;
         ConnectionPool c=ConnectionPool.getInstance();
         c.initialize();
         Connection conn=c.getConnection();
         try{
             String sql="select * from users where Username=? and Password=?";

             PreparedStatement pstmt=conn.prepareStatement(sql);
             pstmt.setString(1,uname);
             pstmt.setString(2,pwd);
             ResultSet rs=pstmt.executeQuery();

             if(rs.next()){
                 System.out.println("Yes It is there");
                 return 1;
             }
         }
             catch(Exception e){
                 System.out.println("Exception"+e);
               }
         finally{
             c.putConnection(conn);
         }

         return st;
     }




     public users authenticate(String un,String pwd){
         users bean=new users();

         ConnectionPool c=ConnectionPool.getInstance();
         c.initialize();
         Connection conn=c.getConnection();
         try{
         //  String sql = "Select * from users where username = '" + un + "' and password = '" + pwd + " ' ";
             String sql = "select * from users where Username = '" + un +" ' and Password = '" + pwd + " ' ";
             PreparedStatement pstmt= conn.prepareStatement(sql);
             ResultSet rs=pstmt.executeQuery();
             if(rs.next()){
                 bean.setUid(rs.getInt("Uid"));
                bean.setUsername(rs.getString("Username"));
                bean.setName(rs.getString("Name"));
                bean.setAddress(rs.getString("Address"));
                bean.setMobile(rs.getString("Mobile"));
                bean.setEmail(rs.getString("Email"));

             }
             c.putConnection(conn);
         }
         catch(Exception e){
             System.out.println("Exception" +e);
         }
         finally{
             c.putConnection(conn);
         }
         return bean;

     }


















     public String getOptions() {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        String rows = new String();
        try {
            Statement stmt = conn.createStatement();
            String sql = "select Uid,Username,Password,Name,Address,Mobile,Email from users ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                rows += " <option value=" + rs.getInt(1) + "> "
                        + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " +rs.getString(4) + "  "+rs.getString(5) + "  "+rs.getString(6)+ "  "+rs.getString(7) +  "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            c.putConnection(conn);
        }
        return rows;
    }

      public static void main(String[] args) {
      usersDao cd = new usersDao();

  //  users cb=new users(7,"yash","abc@1234","Aniruddh","Bhopal","8269332476","aniruddhratahod@gmail.com");
 //   cd.create(cb);



//   cd.edit(cb);


      //cd.remove(2);


 /*       ArrayList<users> cb = cd.findAll();
        for (users c : cb) {
        System.out.println(c.getAccount());
        System.out.println(c.getTran_date());
        System.out.println(c.getAmount());
        System.out.println(c.getUserid());
        System.out.println(c.getOperation());
        }
*/
          /*  int c=cd.checkAvailablity("ani");
      //  String s = String.valueOf(c);
        System.out.println(c);
           */

   /*   int c=cd.checkAvailablity("ani","abc@123");
      String s=String.valueOf(c);
      System.out.println(s);
*/

      users c=cd.authenticate("harendra","acr@");
      System.out.println(c.getUid());
       System.out.println(c.getName());
        System.out.println(c.getAddress());
        System.out.println(c.getMobile());
        System.out.println(c.getEmail());

      }


//        users c=cd.find(3) ;
//        System.out.println(c.getAccount());

      /*  ArrayList<users> cb = cd.findAll();
        for (users c : cb) {
        System.out.println(c.getAccount());
        }
*/
    //  System.out.println(cd.getOptions());
    }



