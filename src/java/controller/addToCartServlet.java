    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import Cart.CartObj;
import dao.CategoryDAO;
import dao.ProductDAO;
import dto.CartDTO;
import dto.CategoryDTO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class addToCartServlet extends HttpServlet {

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
               try {
            String id = request.getParameter("idC");
            String name = request.getParameter("nameC");
            String username = request.getParameter("usernameC");
            double price = Double.parseDouble(request.getParameter("priceC"));
            Date dateCre = new java.util.Date();
            String image = request.getParameter("imgC");
            String description = request.getParameter("descriptionC");
            int quantity = Integer.parseInt(request.getParameter("quantityC"));
            String cate = request.getParameter("cateC");

            HttpSession session = request.getSession();
            CartObj shoppingCart = (CartObj) session.getAttribute("CART");
            if (shoppingCart == null) {
                shoppingCart = new CartObj(username);
            }

            CartDTO dto = new CartDTO();
            dto.setId(id);
            dto.setName(name);
            dto.setQuantity(quantity);
            dto.setPrice(price);
            dto.setQuantityCart(1);
            dto.setCategory(cate);
            dto.setDate(dateCre);
            dto.setDescription(description);
            dto.setImage(image);

            shoppingCart.addToCart(dto);
            session.setAttribute("username", username);
            session.setAttribute("CART", shoppingCart);
           
            
        } catch (Exception e) {
            log("ERROR at AddToCartController" + e.getMessage());
        } finally {
            request.getRequestDispatcher("loadProductServlet").forward(request, response);

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