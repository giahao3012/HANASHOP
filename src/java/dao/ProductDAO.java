/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import dbconnect.MyConnection;
import dto.ProductDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDAO() {
    }
    private void closeConnection() throws Exception
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
    
    public List<ProductDTO> getAllProducts() throws Exception
    {
        List<ProductDTO> list=null;
        try {
            conn=MyConnection.getMyConnection();
            String sql="Select * from productTBL";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            list=new ArrayList<>();
            while(rs.next())
            {
               String id = rs.getString("productID");
               String name=rs.getString("productName");
               String img=rs.getString("productImg");
               String description=rs.getString("description");
               String cateID=rs.getString("productCategoryID");
               String publishCom=rs.getString("publishingCompany");
               double price=rs.getDouble("price");
               int quantity=rs.getInt("quantity");
               ProductDTO p=new ProductDTO(id, name, img, description,cateID,publishCom, price,quantity);
               list.add(p);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            finally
        {
            closeConnection();
        }
        return list;
    }
    public List<ProductDTO> getProductsPaging(int index) throws Exception
    {
        List<ProductDTO> list=null;
        try {
            conn=MyConnection.getMyConnection();
            String sql="Select * from productTBL\n" +
                        "order by dateOfCreate DESC\n" +
                        "OFFSET ? ROWS\n" +
                        "FETCH FIRST 6 ROWS ONLY;";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, (index-1)*6);
            rs=pst.executeQuery();
            list=new ArrayList<>();
            while(rs.next())
            {
               String id = rs.getString("productID");
               String name=rs.getString("productName");
               String img=rs.getString("productImg");
               String description=rs.getString("description");
               String cateID=rs.getString("productCategoryID");
               String publishCom=rs.getString("publishingCompany");
               double price=rs.getDouble("price");
               int quantity=rs.getInt("quantity");
               ProductDTO p=new ProductDTO(id, name, img, description,cateID,publishCom, price,quantity);
               list.add(p);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            finally
        {
            closeConnection();
        }
        return list;
    }
    public List<ProductDTO> getAllProductsbyCid(String cid,int index) throws Exception
    {
        List<ProductDTO> list=null;
        try {
            conn=MyConnection.getMyConnection();
            String sql="Select * from productTBL\n" +
                        "where productCategoryID=? AND isDisable=0 \n" +
                        "order by dateOfCreate DESC\n" +
                        "OFFSET ? ROWS\n" +
                        "FETCH FIRST 6 ROWS ONLY;";
            pst=conn.prepareStatement(sql);
            pst.setString(1, cid);
            pst.setInt(2, (index-1)*6);
            rs=pst.executeQuery();
            list=new ArrayList<>();
            while(rs.next())
            {
               String id = rs.getString("productID");
               String name=rs.getString("productName");
               String img=rs.getString("productImg");
               String description=rs.getString("description");
               String cateID=rs.getString("productCategoryID");
               String publishCom=rs.getString("publishingCompany");
               double price=rs.getDouble("price");
               int quantity=rs.getInt("quantity");
               ProductDTO p=new ProductDTO(id, name, img, description,cateID,publishCom, price,quantity);
               list.add(p);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
            finally
        {
            closeConnection();
        }
        return list;
    }
    public ProductDTO getProductbyID(String id) throws Exception
    {
        ProductDTO p=null;
        conn=MyConnection.getMyConnection();
        try {
            if(conn!=null)
            {
                String sql="Select * from productTBL\n" +
                            "where productID=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            rs=pst.executeQuery();
            while(rs.next())
                {
                   p=new ProductDTO(rs.getString("productID"),
                                    rs.getString("productName"),
                                    rs.getString("productImg"), 
                                    rs.getString("description") ,
                                    rs.getString("productCategoryID"),
                                    rs.getString("publishingCompany"), 
                                    rs.getDouble("price"),
                                    rs.getInt("quantity"),
                                    rs.getDate("dateOfCreate"),
                                    rs.getBoolean("stillProducting"),
                                    rs.getBoolean("isDisable"));
                }
            }
            
        } catch (Exception e) {
        }
        return p;
    }
        public List<ProductDTO> getProductbyPrice(int min,int max,int index) throws Exception
    {
        List<ProductDTO> list=null;
        conn=MyConnection.getMyConnection();
        try {
            if(conn!=null)
            {
                String sql="Select * from productTBL\n" +
                            "where price>=? AND price<=?\n" +
                            "order by dateOfCreate DESC\n" +
                            "OFFSET ? ROWS\n" +
                            "FETCH FIRST 6 ROWS ONLY;";
            pst=conn.prepareStatement(sql);
            pst.setInt(1, min);
            pst.setInt(2, max);
            pst.setInt(3, (index-1)*6);
            list = new ArrayList<>();
            rs=pst.executeQuery();
            while(rs.next())
                {
                   ProductDTO p=new ProductDTO(rs.getString("productID"),
                                    rs.getString("productName"),
                                    rs.getString("productImg"), 
                                    rs.getString("description") ,
                                    rs.getString("productCategoryID"),
                                    rs.getString("publishingCompany"), 
                                    rs.getDouble("price"),
                                    rs.getInt("quantity"),
                                    rs.getDate("dateOfCreate"),
                                    rs.getBoolean("stillProducting"),
                                    rs.getBoolean("isDisable"));
                   list.add(p);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public List<ProductDTO> getProductsByLikeName(String search,int index) throws Exception {
        List<ProductDTO> list = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Select * from productTBL\n" +
                         "where productName LIKE ? AND isDisable=0\n" +
                         "order by dateOfCreate DESC\n" +
                         "OFFSET ? ROWS\n" +
                         "FETCH FIRST 6 ROWS ONLY;";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + search + "%");
            pst.setInt(2, (index-1)*6);
            rs = pst.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
               String id = rs.getString("productID");
               String name=rs.getString("productName");
               String img=rs.getString("productImg");
               String description=rs.getString("description");
               String cateID=rs.getString("productCategoryID");
               String publishCom=rs.getString("publishingCompany");
               double price=rs.getDouble("price");
               int quantity=rs.getInt("quantity");
               ProductDTO p=new ProductDTO(id, name, img, description,cateID,publishCom, price,quantity);
               list.add(p);
            }
        } finally {
            closeConnection();
        }
        return list;
    }
     public int createProduct(ProductDTO p) throws Exception
    {
        conn=MyConnection.getMyConnection();
         int result=0;
         String id=p.getId();
         String name=p.getName();
         String description=p.getDescritption();
         String categoryID=p.getCategoryID();
         String publishingCompany=p.getPublishingCompany();
         double price=p.getPrice();
         int quantity=p.getQuantity();
         String img=p.getImg();
        if(conn!=null)
        {
            String sql="insert productTBL values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, img);
            pst.setString(4, description);
            pst.setString(9, categoryID);
            pst.setDouble(5, price);
            pst.setInt(6, quantity);
            pst.setTimestamp(7, new Timestamp(p.getCreateDate().getTime()));
            pst.setString(8, publishingCompany);
            pst.setBoolean(10, false);
            pst.setBoolean(11, true);
            result=pst.executeUpdate();
        }
        return result;
    }
    public int updateProduct(ProductDTO p) throws Exception
    {
        conn=MyConnection.getMyConnection();
        int result=0;
         String id=p.getId();
         String name=p.getName();
         String description=p.getDescritption();
         String categoryID=p.getCategoryID();
         String publishingCompany=p.getPublishingCompany();
         double price=p.getPrice();
         int quantity=p.getQuantity();
         String img=p.getImg();
        if(conn!=null)
        {
            String sql="Update productTBL set\n" +
                        "productName=?,\n" +
                        "productImg=?,\n" +
                        "description=?,\n" +
                        "price=?,\n" +
                        "quantity=?,\n" +
                        "dateOfCreate=?,\n" +
                        "publishingCompany=?,\n" +
                        "productCategoryID=?,\n" +
                        "isDisable=?,\n" +
                        "stillProducting=? where productID=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(11, id);
            pst.setString(1, name);
            pst.setString(2, img);
            pst.setString(3, description);
            pst.setString(8, categoryID);
            pst.setDouble(4, price);
            pst.setInt(5, quantity);
            pst.setTimestamp(6, new Timestamp(p.getCreateDate().getTime()));
            pst.setString(7, publishingCompany);
            pst.setBoolean(9, false);
            pst.setBoolean(10, true);
            result=pst.executeUpdate();
        }
        return result;
    }
    
     public int deleteProduct(String pid) throws Exception
    {
        conn=MyConnection.getMyConnection();
        int result=0;
        if(conn!=null)
        {
            String sql1="delete from productTBL\n" +
                        "where productID=?";
            PreparedStatement pst=conn.prepareStatement(sql1);
            pst.setString(1, pid);
            result=pst.executeUpdate();
        }
        return result;
    }
     
     public int getNumberPage()
     {
         try {
             conn=MyConnection.getMyConnection();
             String sql="select count(*) from productTBL";
             pst=conn.prepareStatement(sql);
             rs=pst.executeQuery();
             while (rs.next()) {
                int total=rs.getInt(1);
                int countPage=0;
                countPage=total/6;
                if(total%6!=0)
                {
                    countPage++;
                }
                return countPage;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return 0;
     }
        public int getNumberPageSbN(String name)
     {
         try {
             conn=MyConnection.getMyConnection();
             String sql="select count(*) from productTBL\n" +
                        "where productName LIKE ? AND isDisable=0 ";
             pst=conn.prepareStatement(sql);
             pst.setString(1, "%" + name + "%");
             rs=pst.executeQuery();
             while (rs.next()) {
                int total=rs.getInt(1);
                int countPage=0;
                countPage=total/6;
                if(total%6!=0)
                {
                    countPage++;
                }
                return countPage;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return 0;
     }
           public int getNumberPageSbP(int min,int max)
     {
         try {
             conn=MyConnection.getMyConnection();
             String sql="select count(*) from productTBL\n"
                        +"where price>=? AND price<=?";
             pst=conn.prepareStatement(sql);
             pst.setInt(1, min);
             pst.setInt(2, max);
             rs=pst.executeQuery();
             while (rs.next()) {
                int total=rs.getInt(1);
                int countPage=0;
                countPage=total/6;
                if(total%6!=0)
                {
                    countPage++;
                }
                return countPage;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return 0;
     }
    public int getNumberPageSbC(String cid)
     {
         try {
             conn=MyConnection.getMyConnection();
             String sql="select count(*) from productTBL\n" +
                        "where productCategoryID=? AND isDisable=0 ";
             pst=conn.prepareStatement(sql);
             pst.setString(1, cid);
             rs=pst.executeQuery();
             while (rs.next()) {
                int total=rs.getInt(1);
                int countPage=0;
                countPage=total/6;
                if(total%6!=0)
                {
                    countPage++;
                }
                return countPage;
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return 0;
     }
     public boolean updateQuantityProduct(int quantity,String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update productTBL set quantity = ? Where productID = ?";
            conn = MyConnection.getMyConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, id);
            check = pst.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
//    public static void main(String[] args) {
//        try {
//             List<ProductDTO> l=new ArrayList<>();
//             ProductDAO dao=new ProductDAO();
//             l=dao.getProductbyPrice(10, 70, 1);
//        for (ProductDTO productDTO : l) {
//            System.out.println(productDTO.getName());
//        }
////        ProductDTO p=dao.getProductbyID("D2");
////            System.out.println(p.getName());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
