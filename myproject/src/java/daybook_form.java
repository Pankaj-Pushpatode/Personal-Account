/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.yash.jdbc.bank_book.bank_book;
import com.yash.jdbc.bank_book.bank_bookDao;
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
public class daybook_form extends HttpServlet {
   
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


                String edate=request.getParameter("edate");
        String sdate=request.getParameter("sdate");
    //    int uid=Integer.parseInt(request.getParameter("userid"));





       bank_bookDao cd=new bank_bookDao();
        bank_book cb=new bank_book();
      //  ArrayList<cash_book> ar=cd.findAllDateWise(sdate, edate, uid);

       if(edate!=null&&sdate!=null){


            cb.setTran_date(sdate);
            cb.setTran_date(edate);
        //    cb.setUserid(uid);


        }


      //  String opn = request.getParameter("opn");

       // if(opn.equals("find")){

            response.sendRedirect("bank_book?opn=find");


        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet daybook_form</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet daybook_form at " + request.getContextPath () + "</h1>");
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
