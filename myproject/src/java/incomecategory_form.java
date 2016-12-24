/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.income_category.income_category;
import com.yash.jdbc.income_category.income_categoryDao;
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
public class incomecategory_form extends HttpServlet {
   
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






        String inccatname = request.getParameter("categoryname");
        String inccatdetails = request.getParameter("details");
       // 


        income_category bean=new income_category();
        income_categoryDao icd=new income_categoryDao();

         if(inccatname !=null && inccatdetails !=null){

            bean.setInc_catname(inccatname);
            bean.setInc_catdetails(inccatdetails);

           // bean.setUserid(uid);
        }
        int d=0,s=0;
        String opn = request.getParameter("opn");

        if(opn.equals("add")){
            int uid=Integer.parseInt(request.getParameter("userid"));
            bean.setUserid(uid);

           icd.create(bean);
       }

        else if(opn.equals("delete")){
            d=Integer.parseInt(request.getParameter("inc_catid"));

            icd.remove(d);

        }

         else if(opn.equals("update")){

             int inc_catid=Integer.parseInt(request.getParameter("inc_catid"));
             d=Integer.parseInt(request.getParameter("userid"));
           bean.setInc_catid(inc_catid);
             bean.setUserid(d);
             icd.edit(bean);


        }




        response.sendRedirect("income_categories");

        try {




            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet incomecategory_form</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet incomecategory_form at " + request.getContextPath () + "</h1>");
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
