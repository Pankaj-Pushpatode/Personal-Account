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

/**
 *
 * @author YASH KUMAR
 */
public class registration extends HttpServlet {
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

              //               rd = request.getRequestDispatcher("sidebar.html");
                //            rd.include(request, response);



                                out.println("<section id=\"content\" class=\"column-right\">");

	                 out.println("<article>");






                           out.println("<div align=\"center\">");


                         out.println("<form method=\"post\" action=\"registration_form\">");
                      out.println("<table>");
                  out.println("<tr bgcolor=\"black\"><td colspan=2><font color=\"white\">User Registration</font></td></tr>");
                  out.println("<tr><td><b>User Name*</b></td><td><input type=\"text\" name=\"uname\" required title=\"Enter user-name\"/></td> </tr>");
                  out.println("<tr><td><b>Password*</b></td><td><input type=\"text\" name=\"pwd\" pattern=\"{4,}\" title=\"please enter valid password (min.4char)\" required/></tr>");
                  out.println("<tr><td><b>Name*</b></td><td><input type=\"text\" name=\"name\" required title=\"Enter your name\"/> </td></tr>");
                  out.println("<tr><td><b>Address*</b></td><td><input type=\"text\" name=\"address\" required title=\"Enter your Address\"/></td> </tr>");
                  out.println("<tr><td><b>Mobile No.*</b></td><td><input type=\"text\" name=\"mob\" pattern=\"[0-9]{10,}\" title=\"please enter mobile no.\" required/></td> </tr>");
                  out.println("<tr><td><b>E-Mail*</b></td><td><input type=\"email\" name=\"email\" required title=\"Enter valid email-id\"/></td></tr>");
                  out.println("<tr bgcolor=\"black\"> <td><input type=\"submit\" value=\"Register\" /></td> <td><input type=\"reset\" value=\"Cancel\" /></td></tr>");
                      out.println("</table>");
                  out.println("</form>");
                  out.println("</div>");
                  out.println("</section>");


                            rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);



            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registration</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registration at " + request.getContextPath () + "</h1>");
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
