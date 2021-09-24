package sbarrido.reimbursement.dto.model;

public class DestinationDto {
    private Long id;
    private String location;
    private double distance;

    public DestinationDto(){}

    public void setId(Long id) {
        this.id = id;
    }
    public void setDest(String loc) {
        this.location = loc;
    }
    public void setDist(double dist) {
        this.distance = dist;
    }

    public Long getId() {
        return this.id;
    }
    public String getDest() {
        return this.location;
    }
    public double getDist() {
        return this.distance;
    }
}