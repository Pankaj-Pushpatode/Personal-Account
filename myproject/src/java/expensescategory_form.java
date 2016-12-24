/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.expenses_category.expenses_category;
import com.yash.jdbc.expenses_category.expenses_categoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YASH KUMAR
 */
public class expensescategory_form extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      //  response.setContentType("text/html;charset=UTF-8");
    
        response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
        String expcatname = request.getParameter("categoryname");
        String expcatdetails = request.getParameter("details");
       

        expenses_category bean=new expenses_category();
        expenses_categoryDao ed=new expenses_categoryDao();
        if(expcatname !=null && expcatdetails !=null){

            bean.setExp_catname(expcatname);
            bean.setExp_catdetails(expcatdetails);
            
        }
        int d=0;
        String opn = request.getParameter("opn");

        if(opn.equals("add")){

             int uid=Integer.parseInt(request.getParameter("userid"));
             bean.setUserid(uid);

           ed.create(bean);
       }




        else if(opn.equals("delete")){

     d=Integer.parseInt(request.getParameter("exp_catid"));
     ed.remove(d);
         }

        else if(opn.equals("update")){
           
            d=Integer.parseInt(request.getParameter("expcatid"));
            bean.setExp_catid(d);
            int uid=Integer.parseInt(request.getParameter("userid"));
             bean.setUserid(uid);

           ed.edit(bean);
        }

                    response.sendRedirect("expenses_categories");


        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet expensescategory_form</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet expensescategory_form at " + request.getContextPath () + "</h1>");
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
