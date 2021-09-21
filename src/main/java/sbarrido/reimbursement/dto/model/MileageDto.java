package sbarrido.reimbursement.dto.model;

import java.util.Date;

public class MileageDto { 
    private Date date;
    private String description;
    private DestinationDto destDto;
    private double cost;

    public MileageDto() {}

    public Date getDate() {
        return this.date;
    }
    public String getDesc() {
        return this.description;
    }
    public DestinationDto getDest() {
        return this.destDto;
    }
    public double getCost() {
        return this.cost;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setDesc(String val) {
        this.description = val;
    }
    public void setDest(DestinationDto dto) {
        this.destDto = dto;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
}