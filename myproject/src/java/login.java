/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
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
public class login extends HttpServlet {
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
                              
                              rd = request.getRequestDispatcher("home.html");
                           rd.include(request, response);
                             rd = request.getRequestDispatcher("header.html");
                           rd.include(request, response);

                         //    rd = request.getRequestDispatcher("sidebar.html");
                         //   rd.include(request, response);



                                out.println("<section id=\"content\" class=\"column-right\">");

	                 out.println("<article>");
              out.println("<div align=\"center\">");        
              out.println("<form method=\"post\" action=\"Athentication\">");
              out.println("<table>");
              out.println("<tr><th bgcolor=\"black\" valine=\"center\" colspan=2><font color=\"white\"<h1><b>log in here...</b></h1></font></tr><br><br><br>");
              out.println("<tr><td><b>User Name : </b></td> <td><input type=\"text\" name=\"user\" title=\"Enter User-Name\" required/></td></tr> <br>");
              out.println("<tr><td><b>Password : </b></td><td> <input type=\"password\" name=\"pass\" pattern=\"{4,}\" title=\"Enter Your Password\"  required /></td></tr> <br> <br>");
              out.println("<tr><td><input type=\"submit\" class=\"button\" value=\"log-in\"/></td>");
              out.println("<td><a href=\"registration\">New-User</a></</td></tr>");
              out.println("</th>");
              out.println("</table>");
              out.println("</form>");
               String msg = request.getParameter("msg");
            if (msg != null) {
                out.println("<font color=\"red\"><h3>Incorrect Username and Password<h3></font>");
            }
              out.println("</div>");


                out.println("</section>");


                            rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);


              out.println("</body>");
            out.println("</html>");
              
            
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
