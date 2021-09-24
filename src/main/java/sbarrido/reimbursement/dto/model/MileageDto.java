package sbarrido.reimbursement.dto.model;

import java.util.Date;

public class MileageDto { 
    private Long id;
    private Date date;
    private String description;
    private DestinationDto destDto;
    private double cost;

    public MileageDto() {}

    public Long getId() {
        return this.id;
    }
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

    public void setId(Long id) {
        this.id = id;
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