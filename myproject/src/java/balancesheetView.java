/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.yash.jdbc.expenses.expenses;
import com.yash.jdbc.expenses.expensesDao;
import com.yash.jdbc.incomes.incomes;
import com.yash.jdbc.incomes.incomesDao;
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
public class balancesheetView extends HttpServlet {
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


                         usersDao ud = new usersDao();

             users ub = ud.authenticate(un, pwd);
            int id=ub.getUid();




            out.println("<tr> <input type=\"hidden\" name=\"userid\" value="+ub.getUid()+" /></tr>");





    String edate=request.getParameter("edate");
             String sdate=request.getParameter("sdate");










             out.println("<div align=\"center\">");
             out.println("<table>");
             out.println("<form method=\"post\" action=\"#\">");

             out.println("<tr bgcolor=\"black\"><th colspan=6 align=\"center\"><font color=\"white\">Balance Sheet</font></th></tr>");
             out.println("<tr bgcolor=\"black\"><th colspan=2><font color=\"white\">Date From</font></th><th colspan=2><font color=\"white\">To</font></th><th colspan=2 rowspan=2><input type=\"submit\" value=\"Show\"></th></tr>");
             out.println("<tr><td colspan=2><input type=\"date\" name=\"sdate\" value="+sdate+" title=\"Enter Date\" required/></td> <td><input type=\"date\" name=\"edate\" value="+edate+" title=\"Enter Date\" required/></td></tr> <br>");
             out.println("</form><br><br><br>");
             out.println("</table>");

             out.println("</br></br></br>");






          out.println("<table>");
          out.println("<tr><th>&nbsp</th><th>&nbsp</th><th>&nbsp</th><th>&nbsp</th><th>&nbsp</th><th>&nbsp</th></tr>");
          out.println("<tr bgcolor=\"black\"><th colspan=6 align=\"center\"><font color=\"white\">Incomes</font></th><tr>");

          out.println("<tr bgcolor=\"black\"><th colspan=2><font color=\"white\">Incomes</font></td><th><font color=\"white\">Amount</font></th></tr>");




             /*   incomesDao ind=new incomesDao();
                ArrayList<incomes> ir=ind.findAllDateWise(sdate, edate, id);


                for(incomes bean:ir){


          out.println("<tr><td colspan=2>"+bean.getInc_ac()+"</td><td>"+bean.getAmount()+"</td>");
       
            }

                expensesDao ed=new expensesDao();
                ArrayList<expenses> er=ed.findAllDateWise(sdate, edate, id);

                for(expenses ebean:er){
                     out.println("<td colspan=2>"+ebean.getExp_ac()+"</td><td>"+ebean.getAmount()+"</td></tr>");
                }*/


          incomesDao ind=new incomesDao();
          double cb=ind.sum(id,sdate,edate);
                ArrayList<incomes> ir=ind.findAllDateWise(sdate, edate, id);


                for(incomes bean:ir){


          out.println("<tr><td colspan=2>"+bean.getInc_ac()+"</td><td>"+bean.getAmount()+"</td></tr>");
         
        }
  out.println("<tr><th colspan=2>Total</th><th>"+cb+"</th></tr>");
                 out.println("</table>");
                 out.println("</br></br></br>");
                  out.println("<table>");

                   out.println("<tr><th colspan=3 align=\"center\"><font color=\"white\">Expenses</font></th></tr>");
                   out.println("<tr bgcolor=\"black\"><th ><font color=\"white\">Expenses</font></th><th><font color=\"white\">Amount</font></th></tr>");

                expensesDao ed=new expensesDao();
                double sum=ed.sum(id, sdate, edate);
                ArrayList<expenses> er=ed.findAllDateWise(sdate, edate, id);

                for(expenses ebean:er){
                     out.println("<tr><td>"+ebean.getExp_ac()+"</td><td>"+ebean.getAmount()+"</td></tr>");
                }

out.println("<tr><th colspan=1>Total</th><th>"+sum+"</th></tr>");

double gp=cb-sum;
out.println("<tr><th colspan=2>Gross Profit</th><th>"+gp+"</th></tr>");



            out.println("</table>");

          out.println("</div>");



            

   out.println("</section>");




rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);



















            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet balancesheetView</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet balancesheetView at " + request.getContextPath () + "</h1>");
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
