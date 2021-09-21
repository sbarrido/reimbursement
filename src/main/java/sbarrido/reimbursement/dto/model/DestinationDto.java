package sbarrido.reimbursement.dto.model;

public class DestinationDto {
    private String location;
    private double distance;

    public DestinationDto(){}

    public void setDest(String loc) {
        this.location = loc;
    }
    public void setDist(double dist) {
        this.distance = dist;
    }

    public String getDest() {
        return this.location;
    }
    public double getDist() {
        return this.distance;
    }
}