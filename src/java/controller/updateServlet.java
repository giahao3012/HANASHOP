/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
public class updateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCESS="manageServlet";
    private final String FAILED="Error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
        try (PrintWriter out = response.getWriter()) {
             String url=FAILED;
            try {
//            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
//            if (!isMultiPart) {
//
//            } else {
//                FileItemFactory factory = new DiskFileItemFactory();
//                ServletFileUpload upload = new ServletFileUpload(factory);
//                List items = null;
//                try {
//                    items = upload.parseRequest((RequestContext) request);
//                } catch (FileUploadException e) {
//                    e.printStackTrace();
//                }
//                Iterator iter = items.iterator();
//                Hashtable params = new Hashtable();
//                String fileName = null;
//                while (iter.hasNext()) {
//                    FileItem item = (FileItem) iter.next();
//                    if (item.isFormField()) {
//                        params.put(item.getFieldName(), item.getString());
//                    } else {
//                        try {
//                            String itemName = item.getName();
//                            fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
//                            String RealPath = getServletContext().getRealPath("/") + "images\\" + fileName;
//                            File saveFile = new File(RealPath);
//                            item.write(saveFile);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                String id=request.getParameter("id");
                String name=request.getParameter("name");
                String img=request.getParameter("img");
                String description=request.getParameter("description");
                double price=Double.parseDouble(request.getParameter("price"));
                int quantity=Integer.parseInt(request.getParameter("quantity"));
                String publishCompany=request.getParameter("publishingCompany");
                String cateID=request.getParameter("category");
                
                ProductDAO dao=new ProductDAO();
                boolean valid=true;
                
                ProductDTO dto=new ProductDTO(id, name, img, description, cateID, publishCompany,
                        price,quantity,new java.util.Date(), false, true);

//                if(valid)
//                {
                    if(dao.updateProduct(dto)!=0)
                    {
                        url=SUCESS;
                    }
//                }else
//                {
//                    
//                }

//            }
        } catch (Exception e) {
            log("Error at UpdateController " + e.getMessage());
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
