package sbarrido.reimbursement.dto.model;

import java.util.Date;

public class OtherExpDto { 
    private Date date;
    private String description;
    private double cost;
    private String vendor;
    private String receiptPath;

    public OtherExpDto() {}

    public Date getDate() {
        return this.date;
    }
    public String getDesc() {
        return this.description;
    }
    public double getCost() {
        return this.cost;
    }
    public String getVendor() {
        return this.vendor;
    }
    public String getReceiptPath() {
        return this.receiptPath;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setDesc(String val) {
        this.description = val;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setVendor(String val) {
        this.vendor = val;
    }
    public void setReceiptPath(String path) {
        this.receiptPath = path;
    }
}