/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbconnect.MyConnection;
import dto.AccountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class AccountDAO {
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
    
    public AccountDTO checkLogin(String username, String password) throws Exception
    {
        AccountDTO result = null;
        try {
            conn=MyConnection.getMyConnection();
            if(conn!=null)
            {
                String sql="select * from AccountTBL\n" +
                        "where username=? and password=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,username);
                pst.setString(2, password);
                ResultSet rs=pst.executeQuery();
            
             if(rs.next())
             {
                result=new AccountDTO(rs.getString("username"),
                                      rs.getString("password"), 
                                      rs.getString("lastname"),
                                      rs.getString("email"),
                                      rs.getString("role"),
                                      rs.getBoolean("isStillWorking"));
             }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            closeConnection();
        }
        return result;
    }
     public boolean getAccountbyUsername(String username) throws Exception
    {
        boolean check=false;
        try {
            conn=MyConnection.getMyConnection();
            if(conn!=null)
            {
                String sql="select * from AccountTBL\n" +
                        "where username=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,username);
                ResultSet rs=pst.executeQuery();
            
             if(rs.next())
             {
               check=true;
             }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            closeConnection();
        }
        return check;
    }
     public AccountDTO accountbyUsername(String username) throws Exception
    {
        AccountDTO result = null;
        try {
            conn=MyConnection.getMyConnection();
            if(conn!=null)
            {
                String sql="select * from AccountTBL\n" +
                        "where username=?";
                pst=conn.prepareStatement(sql);
                pst.setString(1,username);
                ResultSet rs=pst.executeQuery();
            
             if(rs.next())
             {
               result=new AccountDTO(rs.getString("username"),
                                      rs.getString("password"), 
                                      rs.getString("lastname"),
                                      rs.getString("email"),
                                      rs.getString("role"),
                                      rs.getBoolean("isStillWorking"));
             }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            closeConnection();
        }
        return result;
    }
     public int createAccount(AccountDTO a) throws Exception
    {
        int result=0;
        try {
            conn=MyConnection.getMyConnection();
         String username=a.getUsername();
         String pass=a.getPassword();
         String lastname=a.getLastname();
         String email=a.getEmail();
         String role=a.getRole();
        if(conn!=null)
        {
            String sql="insert AccountTBL values(?,?,?,?,?,0)";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2,pass);
            pst.setString(3, lastname);
            pst.setString(4,email);
            pst.setString(5,role);
            result=pst.executeUpdate();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
//    public static void main(String[] args) {
//        try {
//            AccountDAO dao=new AccountDAO();
//            AccountDTO dto=new AccountDTO("hiaaya", "12345", "Tran Thi B","metquadi@gmail.com");
//            if(dao.createAccount(dto)!=0)
//            {
//                System.out.println("OK");
//            }else
//            {
//                System.out.println("Failed rui ma");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
}
