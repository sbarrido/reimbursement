package sbarrido.reimbursement.model.destination;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Destination {
    @Id
    @GeneratedValue
    private Long id;
    private String location;
    private double distance;

    public Destination() {}
    
    public Destination(String loc, double dist) {
        setDestination(loc);
        setDistance(dist);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setDestination(String loc) {
        this.location = loc;
    }
    public void setDistance(double dist) {
        this.distance = dist;
    }

    public Long getId() {
        return this.id;
    }
    public String getDestination() {
        return this.location;
    }
    public double getDistance() {
        return this.distance;
    }
}