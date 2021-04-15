/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnect.MyConnection;
import dto.CategoryDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDAO {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public void closeConnection() throws Exception
    {
        if(rs!=null)
        {
            rs.close();
        }
        if(pst!=null)
        {
            pst.close();
        }
        if(conn!=null)
        {
            conn.close();
        }
    }
    
    public List<CategoryDTO> getAllCaterogys() throws Exception
    {
        List<CategoryDTO> list=null;
        try {
            conn=MyConnection.getMyConnection();
            String sql="Select * from productCategoryTBL";
             pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            list=new ArrayList<>();
            while(rs.next())
            {
               String id = rs.getString("productCategoryID");
               String name=rs.getString("name");
               CategoryDTO c=new CategoryDTO(id, name);
               list.add(c);
            }
        } catch (Exception e) {
        }finally
        {
            closeConnection();
        }
        return list;
    }
//        public static void main(String[] args) {
//        try {
//             List<CategoryDTO> l=new ArrayList<>();
//             CategoryDAO c=new CategoryDAO();
//             l=c.getAllCaterogys();
//            for (CategoryDTO categoryDTO : l) {
//                System.out.println(categoryDTO.getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
