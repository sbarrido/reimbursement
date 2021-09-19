package sbarrido.reimbursement.model;
import java.util.*;
import java.awt.*;

public class OtherExp extends Reimbursement {
    private String vendor;
    private Image receipt;

    public OtherExp(Date date, String description, String vendor, Image receipt, double cost) {
        setDate(date);
        setDesc(description);
        setImage(receipt);
        setCost(cost);
    }

    public void setCost(double val) {
        this.cost = val;
    }
    public void setVendor(String s) {
        this.vendor = s;
    }
    public void setImage(Image receipt) {
        this.receipt = receipt;
    }

    public String getVendor() {
        return this.vendor;
    }
    public Image getImg() {
        return this.receipt;
    }
}