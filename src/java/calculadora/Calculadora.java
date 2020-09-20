/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwndm
 */
public class Calculadora extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();
        
        int cookieValue = 0;
        
        if (cookies != null) {
          for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            String value = cookies[i].getValue();
            if (name.equals("acessos")) {  
                cookieValue = Integer.parseInt(value) + 1;
            } 
          }
        }
        
        
        Cookie c = new Cookie("acessos", Integer.toString(cookieValue));
        c.setMaxAge(3600 * 24 * 365);
        response.addCookie(c);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(""
                    + "<form action='result.jsp'>"
                        + "<label>Operador 1: </label>"
                        + "<input type='number' name='op1' />"
                        + "<br>"
                        + "<label>Operador 2: </label>"
                        + "<input type='number' name='op2' />"
                        + "<br>"
                        + "<label>Operação: </label>"
                        + "<select name='operation'>"
                            + "<option value='+'>+</option>"   
                            + "<option value='-'>-</option>"   
                            + "<option value='x'>x</option>"   
                            + "<option value='/'>/</option>"   
                        + "</select>"
                        + "<br><br>"
                        + "<button type='submit'>Calcular</button>"
                    + "</form>"
            );
            out.println("</body>");
            out.println("</html>");
        }
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

}
