/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Cart.CartObj;
import dao.OrderDAO;
import dao.ProductDAO;
import dto.CartDTO;
import dto.OrderDTO;
import dto.OrderLineDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class OrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "Error.jsp";
    private static final String SUCCESS = "Cart.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = ERROR;
            try {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String payment = request.getParameter("payment");
            String shipAddr = request.getParameter("shipAddr");
            double Tprice=Double.parseDouble(request.getParameter("Tprice"));
            CartObj shoppingCart = (CartObj) session.getAttribute("CART");
            OrderDAO dao = new OrderDAO();
            ProductDAO daoP = new ProductDAO();
            if (shoppingCart != null) {
                Random random = new Random();
                int idR = random.nextInt(999999);
                java.util.Date dateCreate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(dateCreate.getTime());
                List<OrderDTO> result = dao.loadIdOrder();
                OrderDTO ord=new OrderDTO(idR, username,payment, shipAddr, Tprice, sqlDate);
                if (result.isEmpty()) {
                    if (dao.insertOrder(ord)!=0) {
                        for (CartDTO dto : shoppingCart.getCart().values()) {
                            if (dao.insertOrderDetail(idR,dto.getId(), dto.getQuantityCart(), dto.getPrice())!=0) {
                                if (!daoP.updateQuantityProduct(dto.getQuantity() - dto.getQuantityCart(), dto.getId())) {
                                    url=ERROR;
                                }
                            }
                        }
                        url = SUCCESS;
                        session.setAttribute("CART", null);
                        request.setAttribute("SUCCESS", "Order Successfull");
                    }
                } else {
                    int id = 0;
                    for (OrderDTO dto : result) {
                        id = dto.getOrderID();
                        if (id == idR) {
                            url = SUCCESS;
                        } else {
                            if (dao.insertOrder(ord)!=0) {
                                for (CartDTO dtos : shoppingCart.getCart().values()) {
                                if (dao.insertOrderDetail(idR,dtos.getId(), dtos.getQuantityCart(), dtos.getPrice())!=0) {
                                if (!daoP.updateQuantityProduct(dtos.getQuantity() - dtos.getQuantityCart(),dtos.getId())) {
                                    url=ERROR;
                                }
                            }
                        }
                                url = SUCCESS;
                                session.setAttribute("CART", null);
                                request.setAttribute("SUCCESS", "Order Successfull");
                            }
                        }
                    }
                }
            } else {
                url = ERROR;
                request.setAttribute("ERROR", "Cart is empty!");
            }
            
        } catch (Exception e) {
            log("Error at InsertCartController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
