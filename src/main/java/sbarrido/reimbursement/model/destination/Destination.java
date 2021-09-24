package sbarrido.reimbursement.model.destination;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Destination {
    @Id
    @GeneratedValue
    private long id;
    private String location;
    private double distance;

    public Destination() {}
    
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

    public long getId() {
        return this.id;
    }
    public String getDest() {
        return this.location;
    }
    public double getDist() {
        return this.distance;
    }
}