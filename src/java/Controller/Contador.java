package Controller;
/*@autor Karioca*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*@autor Karioca*/
@WebServlet(name = "Contador", urlPatterns = {"/Contador"})
public class Contador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        int cont = 0;
        String[]users = new String[100];
        String user = request.getParameter("usuario");
        String list= request.getParameter("usuario"); 
        String a;
        
        Cookie[] listaCookies = request.getCookies();
       
        if(listaCookies != null){
            for (Cookie c : listaCookies){ 
                if(c.getName().equals("lista")){  
                   cont = Integer.parseInt(c.getValue());          
                   a = request.getParameter("a");
                   users[cont]= user;
                   list = a + " " + users[cont];
                   request.setAttribute("acessos", list);
                }
            }
        }
        
        request.setAttribute("acessos", list);
             
        cont++;
        
        Cookie n = new Cookie("lista",""+cont);   
        n.setMaxAge(10);       
        response.addCookie(n);

        request.getRequestDispatcher("index.jsp").forward(request, response);
   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/*@autor Karioca*/
}
