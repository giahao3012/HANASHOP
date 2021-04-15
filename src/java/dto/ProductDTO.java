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
public class ProductDTO {
    private String id, name, img, descritption, categoryID, publishingCompany;
    private double price;
    private int quantity;
    private Date createDate;
    private boolean stillProducing;
    private boolean isDisable;
    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String img, String descritption, String categoryID, String publishingCompany, double price, int quantity, Date createDate, boolean stillProducing, boolean isDisable) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.descritption = descritption;
        this.categoryID = categoryID;
        this.publishingCompany = publishingCompany;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.stillProducing = stillProducing;
        this.isDisable = isDisable;
    }
    public ProductDTO(String id, String name, String img, String descritption,String categoryID,String publishingCompany,double price, int quantity) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.descritption = descritption;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.publishingCompany = publishingCompany;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isStillProducing() {
        return stillProducing;
    }

    public void setStillProducing(boolean stillProducing) {
        this.stillProducing = stillProducing;
    }

    public boolean isIsDisable() {
        return isDisable;
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     
}
