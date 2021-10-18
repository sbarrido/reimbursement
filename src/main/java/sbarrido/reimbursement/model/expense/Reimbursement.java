package sbarrido.reimbursement.model.expense;
import java.util.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reimbursement_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Reimbursement {

    @Id
    @GeneratedValue
    private Long id;
    protected double cost;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;

    public abstract void setCost(double val);

    public Long getId() {
        return this.id;
    }
    public double getCost() {
        return this.cost;
    }
    public Date getDate() {
        return this.date;
    }
    public String getDesc() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDate(Date d) {
        this.date = d;
    }
    public void setDesc(String description) {
        this.description = description;
    }
}