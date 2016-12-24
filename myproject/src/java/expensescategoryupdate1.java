/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.expenses_category.expenses_category;
import com.yash.jdbc.expenses_category.expenses_categoryDao;
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
public class expensescategoryupdate1 extends HttpServlet {
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


//        HttpSession session = request.getSession();

         HttpSession session = request.getSession();
            String un = (String) session.getAttribute("user");
            String pwd = (String) session.getAttribute("pass");
            if (un == null && pwd == null) {
                response.sendRedirect("login");
            }

        try {
            // TODO output your page here

             out.println("<!doctype html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />");
                            out.println("<title> Update Expenses_Category</title>");
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
              
               out.println("<form method=\"post\" action=\"ExpensesCategoryForm?opn=update \" >");
            int exp_catid = Integer.parseInt(request.getParameter("exp_catid"));
            expenses_categoryDao da = new expenses_categoryDao();
            expenses_category bean = da.find(exp_catid);
            out.println("<input type=\"hidden\" name=\"exp_catid\" value=" + bean.getExp_catid() + " />");
            out.println("  <b>Category Name : </b> <input type=\"text\" name=\"categoryname\" value=" + bean.getExp_catname() + " /> <br/>");
            out.println("  <b>Category Details  : </b> <input type=\"text\" name=\"details\" value=" + bean.getExp_catdetails() + " /><br/> ");
            out.println(" <input type=\"Submit\" value=\"Update\" />");
            out.println(" <input type=\"Reset\" value=\"Clear Contents\" />");

            out.println(" </form>");
              
              
              
              
              
              
              
              
              
              
              
              
            /*  out.println("<form method=\"post\" action=\"expensescategory_form?opn=update\">");
              int exp_catid=Integer.parseInt(request.getParameter("Exp_catid"));
              expenses_categoryDao ed=new expenses_categoryDao();
              expenses_category bean= ed.find(exp_catid);
            
               out.println("<input type=\"hidden\" name=\"exp_catid\" value=" + bean.getExp_catid() + " />");

              out.println("  <b>Category Name*  </b> <input type=\"text\" name=\"categoryname\" value=" + bean.getExp_catname()+" /> <br/>");

              out.println("<b> Category Details*</b> <input type=\"text\" name=\"categorydetails\" value=" +bean.getExp_catdetails() +"><br/>");

              out.println("<input type=\"submit\" value=\"Update\"/>");
              out.println("<input type=\"reset\" value=\"Cancel\">");
                out.println(" </form>");

            //  rd.include(request, response);
              //out.println("<table>");
             */ out.println("</section>");



                            rd = request.getRequestDispatcher("footer.html");
                            rd.include(request, response);





            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet expensescategoryUpdate</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet expensescategoryUpdate at " + request.getContextPath () + "</h1>");
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
