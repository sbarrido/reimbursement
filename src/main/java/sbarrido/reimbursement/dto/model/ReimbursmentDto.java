package sbarrido.reimbursement.dto.model;

public abstract class ReimburseemntDto extends RepresentationModel<ReimbursementDto> {
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
    public String getDesc() {
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