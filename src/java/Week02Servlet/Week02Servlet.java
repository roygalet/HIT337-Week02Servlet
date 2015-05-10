/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week02Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author roygalet
 */
public class Week02Servlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Week02Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Week02Servlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        
        PrintWriter out = response.getWriter();
//        Part 1
//        out.print("<html><head></head><body><h1>Hello Roy!</h1></body></html>");
//        Part 2
//        String username = request.getParameter("username");
//        out.print("<html><head></head><body><h1>Hello " + username + "</h1></body></html>");
//        Part 3
//        response.setContentType("text/html"); 
//        out.print("<html><head></head><body><form method=\"post\"><input type=\"text\" name=\"username\" /><input type=\"submit\" /></form></body></html>");
        
//        Part 4
        
        ServletContext context = this.getServletContext();
        String unit = context.getInitParameter("Unit");
        
        out.print("<html><head></head><body><h1>Unit " + unit + "</h1>");
        ServletConfig config = this.getServletConfig();
        Enumeration<String> configParams = config.getInitParameterNames();
        while (configParams.hasMoreElements()) {
            String initParamName = configParams.nextElement().toString();
            out.println("<h2>paramn name: "+initParamName);
            String initParamValue = getServletConfig().getInitParameter(initParamName);
            out.println("param value: "+initParamValue + "</h2>");
        }    
        
        out.print("</body></html>");
        
//        Part 5
//        HttpSession session = request.getSession();
//        session.setAttribute("name", "value");
//        String value = (String)session.getAttribute("name");
//        session.removeAttribute("name");
//        out.print("<html><head></head><body><h1>name " + value + "</h1></body></html>");

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
//        processRequest(request, response);
//        Part 3
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        out.print("<html><head></head><body><h1>Hello " + username + "</h1></body></html>");
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
