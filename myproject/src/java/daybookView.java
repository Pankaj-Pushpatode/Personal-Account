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
public class daybookView extends HttpServlet {
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
             out.println("<form method=\"post\" action=\"#\">");
             out.println("<table>");
             out.println("<tr bgcolor=\"black\"><th rowspan=2><font color=\"white\">Day Book</font></th><th><font color=\"white\">Date From</font></th><th><font color=\"white\">To</font></th><th rowspan=2><input type=\"submit\" value=\"Show\"></th></tr>");
             out.println("<tr><td><input type=\"date\" name=\"sdate\" value="+sdate+" title=\"Enter Date\" required/></td> <td><input type=\"date\" name=\"edate\" value="+edate+" title=\"Enter Date\" required/></td></tr> <br>");

             out.println("</form><br><br><br>");
             out.println("</table>");
             out.println("<table>");
             out.println("<tr bgcolor=\"black\"><th><font color=\"white\">S.NO.</font></th><th><font color=\"white\">Account Name</font></th><th><font color=\"white\">Date</font></th><th><font color=\"white\">Amount</font></th><th><font color=\"white\">Pay/Receiv By</font><th><font color=\"white\">Remark</font></th></th></tr>");
             out.println("<tr><th>Expenses</th><td colspan=5></td></tr>");

             expensesDao ed=new expensesDao();
             int i=1;

             ArrayList<expenses> ar=ed.findAllDateWise(sdate, edate, id);
             for(expenses bean:ar){

             out.println("<tr><td>"+i+"</td><td>"+bean.getExp_ac()+"</td><td>"+bean.getTran_date()+"</td><td>"+bean.getAmount()+"</td><td>"+bean.getPayby()+"</td><td>"+bean.getRemark()+"</td></tr>");
             //out.println("<tr><td>2</td><td></td><td></td><td></td><td></td></tr>");

             i=i+1;
            }



             out.println("<tr><th>Income</th><td colspan=5></td></tr>");
           
             incomesDao ind=new incomesDao();
             int j=1;
             ArrayList<incomes> ir=ind.findAllDateWise(sdate, edate, id);
             
           for(incomes bn:ir){  
               
               
                out.println("<tr><td>"+j+"</td><td>"+bn.getInc_ac()+"</td><td>"+bn.getTran_date()+"</td><td>"+bn.getAmount()+"</td><td>"+bn.getReceivby()+"</td><td>"+bn.getRemark()+"</td></tr>"); 
            j=j+1;
            // out.println("<tr><td>1</td><td></td><td></td><td></td><td></td></tr>");
        //     out.println("<tr><td>2</td><td></td><td></td><td></td><td></td></tr>");
            }
             out.println("</table><br><br><br>");
             out.println("</div>");






   out.println("</section>");








                            rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);











            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet day_book</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet day_book at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet daybookView</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet daybookView at " + request.getContextPath () + "</h1>");
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
