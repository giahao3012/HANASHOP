/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ProductManagerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String LOAD="loadProductServlet";
    private static final String DETAIL="DetailServlet";
    private static final String LOGIN="LoginServlet";
    private static final String CATEROGY="loadProductbyCid";
    private static final String UPDATE="updateServlet";
    private static final String CREATE="createServlet";
    private static final String DELETE="deleteServlet";
    private static final String CART="addToCartServlet";
    private static final String DELETECART="deleteCartServlet";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            try {
                String action = request.getParameter("action");
                RequestDispatcher rd;
                if(action==null)
                {
                    rd=request.getRequestDispatcher(LOAD);
                    rd.forward(request, response);
                }if(action.equals("detail"))
                {
                   rd=request.getRequestDispatcher(DETAIL);
                    rd.forward(request, response);
                }if(action.equals("login"))
                {
                    rd=request.getRequestDispatcher(DETAIL);
                    rd.forward(request, response);
                }
                if(action.equals("getPbyCid"))
                {
                    rd=request.getRequestDispatcher(CATEROGY);
                    rd.forward(request, response);
                }if(action.equals("updateform"))
                {
                    rd=request.getRequestDispatcher("GetProductByID");
                    rd.forward(request, response);
                }if(action.equals("Update"))
                {
                    rd=request.getRequestDispatcher(UPDATE);
                    rd.forward(request, response);
                }if(action.equals("Add"))
                {
                    rd=request.getRequestDispatcher(CREATE);
                    rd.forward(request, response);
                }if(action.equals("delete"))
                {
                    rd=request.getRequestDispatcher(DELETE);
                    rd.forward(request, response);
                }if(action.equals("Add To Cart"))
                {
                    rd=request.getRequestDispatcher(CART);
                    rd.forward(request, response);
                }if(action.equals("deleteCart"))
                {
                    rd=request.getRequestDispatcher(DELETECART);
                    rd.forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
