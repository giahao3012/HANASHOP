/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnect.MyConnection;
import dto.CartDTO;
import dto.OrderDTO;
import dto.OrderLineDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDAO {
     private Connection conn;
    private PreparedStatement pre;
    private ResultSet rs;

    public OrderDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pre != null) {
            pre.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public int insertOrder(OrderDTO ord) throws Exception {
        int result=0;
        try {
            String sql = "Insert into OrderTBL values(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            
            if(conn!=null)
            {
                pre = conn.prepareStatement(sql);
                pre.setInt(1, ord.getOrderID());
                pre.setString(2, ord.getUsername());
                pre.setString(3, ord.getPayment());
                pre.setString(4, ord.getShipAddress());
                pre.setDouble(5, ord.getTotal());
                pre.setDate(6, (Date) ord.getDateOrder());
                result=pre.executeUpdate();
            }
            
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<OrderDTO> loadIdOrder() throws Exception {
        int id = 0;
        List<OrderDTO> result = null;
        OrderDTO dto = null;
        try {
            String sql = "select orderID from OrderTBL";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                id = rs.getInt("orderID");
                dto = new OrderDTO(id);
                result.add(dto);
            }
            
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertOrderDetail(int ordID,String proID,int quantity,double price) throws Exception {
        int result=0;
        try {
            String sql = "Insert into OrderDetailTBL values(?,?,?,?)";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, ordID);
            pre.setString(2, proID);
            pre.setInt(3,quantity);
            pre.setDouble(4,price);
            result=pre.executeUpdate();
        } finally {
            closeConnection();
        }
        return result;
    }
     public List<CartDTO> loadHisoryOfUser(String user)throws Exception{
        List<CartDTO> result = null;
        CartDTO dto = null;
        String name = null;
        int price = 0;
        int quan =0;
        String date = null;
        try{
            String sql ="Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date From OrderTBL as o, OrderDetailTBL as od , productTBL as p , AccountTBL as ac\n" +
                        "  Where o.orderID = od.orderID and o.username like ? and p.productID = od.productID and o.username = ac.username";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%"+ user+"%");
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                name = rs.getString("NameP");
                price = rs.getInt("PriceP");
                quan = rs.getInt("QuantityP");
                date = rs.getString("Date");
                dto = new CartDTO(quan, price, name, new SimpleDateFormat("yyyy-MM-dd").parse(date));
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public List<CartDTO> searchHistoryByName(String user, String name)throws Exception{
        List<CartDTO> result = null;
        CartDTO dto = null;
        int price = 0;
        int quan =0;
        String date = null;
        try{
            String sql ="Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date From OrderTBL as o, OrderDetailTBL as od ,productTBL as p, AccountTBL as ac\n" +
                        " Where o.orderID = od.orderID and o.username like ? and p.productID = od.productID and o.username = ac.username and p.productName like ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%"+ user+"%");
            pre.setString(2, "%"+ name+"%");
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                name = rs.getString("NameP");
                price = rs.getInt("PriceP");
                quan = rs.getInt("QuantityP");
                date = rs.getString("Date");
                dto = new CartDTO(quan, price, name, new SimpleDateFormat("yyyy-MM-dd").parse(date));
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
    public List<CartDTO> searchHistoryByDate(String user, String date)throws Exception{
        List<CartDTO> result = null;
        CartDTO dto = null;
        int price = 0;
        String name = null;
        String dateO = null;
        int quan =0;
        try{
            String sql ="Select p.productName as NameP,p.price as PriceP, od.Quantity as QuantityP, o.DateOrder as Date\n" +
"                    From OrderTBL as o, OrderDetailTBL as od , productTBL as p , AccountTBL as ac\n" +
"                    Where o.orderID = od.orderID and o.username like ? and p.productID = od.productID and o.username = ac.username\n" +
"                    and o.DateOrder BETWEEN ? AND ?";
            conn = MyConnection.getMyConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%"+ user+"%");
            pre.setString(2, date +" 00:00:00");
            pre.setString(3, date + " 23:59:59");
            rs = pre.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                name = rs.getString("NameP");
                price = rs.getInt("PriceP");
                quan = rs.getInt("QuantityP");
                dateO = rs.getString("Date");
                dto = new CartDTO(quan, price, name, new SimpleDateFormat("yyyy-MM-dd").parse(date));
                result.add(dto);
            }
        }finally{
            closeConnection();
        }
        return result;
    }
//    public static void main(String[] args) {
//        try {
//            OrderDAO dao=new OrderDAO();
//            java.util.Date now = new java.util.Date();
//            java.sql.Date sqlDate = new java.sql.Date(now.getTime());
//            Random random = new Random();
//                int idR = random.nextInt(999999);
//            OrderDTO ord=new OrderDTO(idR, "lalala","Cash", "123 Lalala", 340,sqlDate);
//            if(dao.insertOrder(ord)!=0)
//            {
//                if(dao.insertOrderDetail(idR, "F1", 2, 88)!=0)
//                { 
//                }
//                System.out.println("OK");  
//            }else
//            {
//                System.out.println("Sai rrr");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
