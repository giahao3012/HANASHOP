/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dto.AccountDTO;
import dto.AccountErrObjDTO;
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
public class SignUpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "Login.jsp";
    private static final String ERROR = "SignUp.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
         String url = ERROR;
        try {
            AccountErrObjDTO errorObj=new AccountErrObjDTO();
            AccountDAO dao=new AccountDAO();
            boolean valid = true;
            String username=request.getParameter("username");
            if (username.trim().isEmpty()) {
                errorObj.setUsernameErr("Username is not empty!!");
                valid = false;
            }if (dao.getAccountbyUsername(username)) {
                errorObj.setUsernameErr("This username is exsited!!");
                valid = false;
            }
            String password=request.getParameter("pass");
            if (password.trim().isEmpty()) {
                errorObj.setPasswordErr("Password is not empty!!");
                valid = false;
            }
            String repass=request.getParameter("repass");
            if(!password.equalsIgnoreCase(repass))
            {
                errorObj.setRePasswordErr("Re=Pass is wrong!!");
                valid = false;
            }
            String lastname=request.getParameter("lastname");
            if (lastname.trim().isEmpty()) {
                errorObj.setLastnameErr("Fullname is not empty!!");
                valid = false;
            }
            String email=request.getParameter("email");  
            if (email.trim().isEmpty()) {
                errorObj.setEmailErr("Email is not empty!!");
                valid = false;
            }
           AccountDTO dto=new AccountDTO(username, password, lastname, email,"user");
            if (valid) {
                if (dao.createAccount(dto)!=0) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("objErr", errorObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally
        {
            request.getRequestDispatcher(url).forward(request, response);
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
