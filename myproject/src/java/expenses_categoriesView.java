/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.expenses_category.expenses_category;
import com.yash.jdbc.expenses_category.expenses_categoryDao;
import com.yash.jdbc.users.users;
import com.yash.jdbc.users.usersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author YASH KUMAR
 */
public class expenses_categoriesView extends HttpServlet {
     private RequestDispatcher rd;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      HttpSession session = request.getSession();
            String un = (String) session.getAttribute("user");
            String pwd = (String) session.getAttribute("pass");
            if (un == null && pwd == null) {
                response.sendRedirect("login");
            }
        try {


             out.println("<!doctype html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />");
                            out.println("<title> my personal account</title>");
                            out.println("<link rel=\"styleshe<!doctype html>et\" href=\"styles.css\" type=\"text/css\" />");
                            out.println("<!--[if lt IE 9]>");
                            out.println("<script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>");
                            out.println("<![endif]-->");
                            out.println("<!--");
                            out.println("afflatus, a free CSS web template by ZyPOP (zypopwebtemplates.com/)");

                            out.println("Download: http://zypopwebtemplates.com/");

                            out.println("License: Creative Commons Attribution");
                            out.println("//-->");
                            out.println("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1.0, maximum-scale=1.0\" />");
                            out.println("</head>");
                             out.println("<body>");
                              rd = request.getRequestDispatcher("menubar.html");
                           rd.include(request, response);
                             rd = request.getRequestDispatcher("header.html");
                           rd.include(request, response);

                             rd = request.getRequestDispatcher("sidebar.html");
                            rd.include(request, response);
                         out.println("<section id=\"content\" class=\"column-right\">");

	                 out.println("<article>");


             out.println("<div align=\"center\">");
              out.println("<form method=\"post\" action=\"expensescategory_form?opn=add\">");
              out.println("<table>");
              usersDao ud = new usersDao();
            users ub = ud.authenticate(un, pwd);
            int id=ub.getUid();
            out.println("<tr> <input type=\"hidden\" name=\"userid\" value="+ub.getUid()+" /></tr>");

              out.println("<tr><th bgcolor=\"black\" valine=\"center\" colspan=2><font color=\"white\"<h1><b>Expenses Categories</b></h1></font></tr><br><br><br>");
             
              out.println("<tr><td><b>Category Name* </b></td> <td><input type=\"text\" name=\"categoryname\"  title=\"Enter Category Name\" required/></td></tr> <br>");
              out.println("<tr><td><b>Category Details*</b></td><td> <textarea rows=2 name=\"details\"></textarea></td></tr> <br> <br>");
               
              out.println("<tr><td><input type=\"submit\" value=\"Submit\"/></td>");
              out.println("<td><input type=\"reset\" value=\"Cancel\"</td></tr>");
              out.println("</th>");
              out.println("</table><br><br><br>");
            //  rd.include(request, response);






              out.println("<table>");

              out.println("<tr bgcolor=\"black\"><th><font color=\"white\">Category Name</font></th><th><font color=\"white\">Category Details</font></th><th><font color=\"white\">Edit</font></th><th><font color=\"white\">Delete</font></th><tr>");


              expenses_categoryDao ed=new expenses_categoryDao();
              ArrayList<expenses_category> list=ed.findAll(id);
              for(expenses_category bean: list){

              out.println("<tr>");
              
              out.println("<td>" + bean.getExp_catname() +"</td>");
              out.println("<td>"+bean.getExp_catdetails() +"</td>");
            //  out.println("<td><a href=\"ExpensesCategoryUpdate?exp_catid=" + bean.getExpCatId() + "\">Edit</a></td>");
              out.println("<td><a href=\"expensescategoryUpdate?Exp_catid=" + bean.getExp_catid()+ "\">Edit</td>");

              //out.println("<td><a href=\"ExpensesCategoryForm?opn=delete&exp_catid=" + bean.getExpCatId() + "\">Delete</a></td>");
              out.println("<td><a href=\"expensescategory_form?opn=delete&exp_catid=" +bean.getExp_catid()+ "\">Delete</td></tr>");
              out.println("</form>");
              out.println("</div>");

            }

                        out.println("</section>");



   rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);



            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet expenses_categoriesView</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet expenses_categoriesView at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
