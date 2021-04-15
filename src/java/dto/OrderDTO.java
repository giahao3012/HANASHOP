/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDTO {
    int orderID;
    String username,payment,shipAddress;
    double total;
    Date dateOrder;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, String username, String payment, String shipAddress, double total, Date dateOrder) {
        this.orderID = orderID;
        this.username = username;
        this.payment = payment;
        this.shipAddress = shipAddress;
        this.total = total;
        this.dateOrder = dateOrder;
    }
    public OrderDTO(int orderID)
    {
        this.orderID=orderID;
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }
    
}
