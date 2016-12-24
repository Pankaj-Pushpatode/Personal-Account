/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.yash.jdbc.users.users;
import com.yash.jdbc.users.usersDao;
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
public class user_form extends HttpServlet {
   
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
        int uid=Integer.parseInt(request.getParameter("id"));
        String uname=request.getParameter("uname");
        String pwd=request.getParameter("pwd");
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        String mob=request.getParameter("mob");
        String email=request.getParameter("email");

        users bean=new users();
        usersDao ud=new usersDao();
        if(uname!=null&&pwd!=null&&name!=null&&address!=null&&mob!=null&&email!=null){
            bean.setUid(uid);
            bean.setUsername(uname);
            bean.setPassword(pwd);
            bean.setName(name);
          //  String add=address.toString();
            bean.setAddress(address);
            bean.setMobile(mob);
            bean.setEmail(email);
       ud.edit(bean);
        }

 response.sendRedirect("login");


        try {






            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet user_form</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet user_form at " + request.getContextPath () + "</h1>");
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
