/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author hieu1
 */
public class MotocycleDTO {

    private String motocycleID;
    private String model;
    private String year;
    private String condition;
    private float price;
    private int quantity;
    private String warranty;
    private String brandID;

    public MotocycleDTO() {
    }

    public MotocycleDTO(String motocycleID, String model, String year, String condition, float price, int quantity, String warranty, String brandID) {
        this.motocycleID = motocycleID;
        this.model = model;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.quantity = quantity;
        this.warranty = warranty;
        this.brandID = brandID;
    }

    public String getMotocycleID() {
        return motocycleID;
    }

    public void setMotocycleID(String motocycleID) {
        this.motocycleID = motocycleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

}
