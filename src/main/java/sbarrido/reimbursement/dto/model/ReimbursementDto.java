package sbarrido.reimbursement.dto.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

public abstract class ReimbursementDto extends RepresentationModel<ReimbursementDto> {
    
    private Long id;
    private Date date;
    private String description;
    private double cost;

    public Long getId() {
        return this.id;
    }
    public Date getDate() {
        return this.date;
    }
    public String getDescription() {
        return this.description;
    }
    public double getCost() {
        return this.cost;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDescription(String desc) {
        this.description = desc;
    }
    public void setCost(double val) {
        this.cost = val;
    }
}