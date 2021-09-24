package sbarrido.reimbursement.model.expense;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("other_expense")
public class OtherExp extends Reimbursement {
    private String vendor;
    private String receiptPath;

    public OtherExp() {}

    public OtherExp(Date date, String description, String vendor, String receiptPath, double cost) {
        setDate(date);
        setDesc(description);
        setImagePath(receiptPath);
        setCost(cost);
    }

    public void setCost(double val) {
        this.cost = val;
    }
    public void setVendor(String s) {
        this.vendor = s;
    }
    public void setImagePath(String path) {
        this.receiptPath = path;
    }

    public String getVendor() {
        return this.vendor;
    }
    public String getImgPath() {
        return this.receiptPath;
    }
}