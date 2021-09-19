package sbarrido.reimbursement.model;
import java.util.*;

public abstract class Reimbursement {
    protected double cost;
    private Date date;
    private String description;

    public abstract void setCost(double val);

    public double getCost() {
        return this.cost;
    }
    public Date getDate() {
        return this.date;
    }
    public String getDesc() {
        return this.description;
    }

    public void setDate(Date d) {
        this.date = d;
    }
    public void setDesc(String description) {
        this.description = description;
    }
}