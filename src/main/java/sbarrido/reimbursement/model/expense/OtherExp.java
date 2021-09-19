package sbarrido.reimbursement.model.expense;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.awt.*;

@Entity
@DiscriminatorValue("other_expense")
public class OtherExp extends Reimbursement {
    private String vendor;
    private Image receipt;

    protected OtherExp() {}

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