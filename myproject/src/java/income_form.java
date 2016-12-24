/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.yash.jdbc.bank_book.bank_book;
import com.yash.jdbc.bank_book.bank_bookDao;
import com.yash.jdbc.cash_book.cash_book;
import com.yash.jdbc.cash_book.cash_bookDao;
import com.yash.jdbc.incomes.incomes;
import com.yash.jdbc.incomes.incomesDao;
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
public class income_form extends HttpServlet {
   
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
        String inc_ac=request.getParameter("income");
        int userid=Integer.parseInt(request.getParameter("userid"));
        int inc_catid=Integer.parseInt(request.getParameter("inccatid"));
        double amount=Double.parseDouble(request.getParameter("amount"));
        String date=request.getParameter("date");
        String receivby=request.getParameter("receivby");
        String remark=request.getParameter("remark");

        incomes bean=new incomes();
        incomesDao id=new incomesDao();
        
      cash_book cb=new cash_book();
      cash_bookDao cd=new cash_bookDao();


       bank_book bb=new bank_book();
        bank_bookDao bd=new bank_bookDao();



        if(inc_ac!=null&&date!=null&&receivby!=null&&remark!=null){
            bean.setInc_ac(inc_ac);
            bean.setUserid(userid);
            bean.setInc_catid(inc_catid);
            bean.setAmount(amount);
            bean.setTran_date(date);
            bean.setReceivby(receivby);
            bean.setRemark(remark);
            
            
            if(receivby.equals("cash")){
            cb.setAccount(inc_ac);
            cb.setTran_date(date);
            cb.setAmount(amount);
            cb.setUserid(userid);
            cb.setOperation("receive");
            }
 else{
            bb.setAccount(inc_ac);
            bb.setTran_date(date);
            bb.setAmount(amount);
            bb.setUserid(userid);
            bb.setOperation("receive");
            }


        }


         String opn=request.getParameter("opn");
        if(opn.equals("add")){
            id.create(bean);

            cd.create(cb);

            bd.create(bb);
        }

        response.sendRedirect("income");

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet income_form</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet income_form at " + request.getContextPath () + "</h1>");
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
