package sbarrido.reimbursement.model.expense;

import javax.persistence.Entity;

@Entity
public class Destination {
    private String location;
    private double distance;

    protected Destination() {}
    
    public Destination(String loc, double dist) {
        setDest(loc);
        setDist(dist);
    }

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