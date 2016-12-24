/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.incomes.incomes;
import com.yash.jdbc.incomes.incomesDao;
import com.yash.jdbc.income_category.income_category;
import com.yash.jdbc.income_category.income_categoryDao;
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
public class income extends HttpServlet {
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
          //HttpSession session = request.getSession();

         HttpSession session = request.getSession();
            String un = (String) session.getAttribute("user");
            String pwd = (String) session.getAttribute("pass");
            if (un == null && pwd == null) {
                session.invalidate();
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
              out.println("<form method=\"post\" action=\"income_form?opn=add\">");
              out.println("<table>");

              usersDao ud = new usersDao();
            users ub = ud.authenticate(un, pwd);
            int uid=ub.getUid();

             out.println("<tr> <input type=\"hidden\" name=\"userid\" value="+ub.getUid()+" /></tr>");
              out.println("<tr><th bgcolor=\"black\" valine=\"center\" colspan=2><font color=\"white\"<h1><b>Income</b></h1></font></tr><br><br><br>");
              out.println("<tr><td><b>Income*</b></td> <td><input type=\"text\" name=\"income\" required/></td></tr> <br>");

              out.println("<tr><td><b>Category*</b></td> <td><select name=\"inccatid\" size=1>");
              income_categoryDao id=new income_categoryDao();
              ArrayList<income_category> ir=id.findAll(uid);
              for(income_category ic:ir){

                  out.println("<option value="+ic.getInc_catid()+" >");
                  out.println(ic.getInc_catname());
                //  out.println(ec.getExp_catname());

              }
              out.println("</select>");
              

              out.println("</td></tr> <br>");
              out.println("<tr><td><b>Amount</b></td> <td><input type=\"text\" name=\"amount\" title=\"Enter Amount\" required/></td></tr> <br>");
              out.println("<tr><td><b>Receive By*</b></td> <td><select name=\"receivby\" size=1>");
               out.println("<option  value=\"cash\">cash</option>");
               out.println("<option value=\"cheque\">cheque</option>");
              out.println("</td></tr> <br>");
              out.println("<tr><td><b>Remark*</b></td> <td><input type=\"text\" name=\"remark\" title=\"Enter Remark\" required/></td></tr> <br>");

              out.println("<tr><td><b>Date*</b></td> <td><input type=\"date\" name=\"date\" title=\"Enter Date\" required/></td></tr> <br>");
              out.println("<tr><td><input type=\"submit\" value=\"Submit\"/></td>");
              out.println("<td><input type=\"reset\" value=\"Cancel\"</td></tr>");
              out.println("</th>");
              out.println("</table></form><br><br><br>");
              out.println("</div>");







              out.println("</section>");




                            rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);













            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet income</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet income at " + request.getContextPath () + "</h1>");
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
