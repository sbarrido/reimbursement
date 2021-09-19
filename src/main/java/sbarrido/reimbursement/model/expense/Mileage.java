package sbarrido.reimbursement.model.expense;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("mileage")
public class Mileage extends Reimbursement {
    public static final double _COMMUTE = 15.2;
    private static final double _RATE = 0.56;
    @OneToOne
    private Destination destination;

    protected Mileage() {}

    public Mileage(Date date, String description, Destination destination) {
        setDate(date);
        setDesc(description);
        setDest(destination);
        setCost(destination.getDist());
    }
    
    public void setCost(double val) {
        this.cost = (val - Mileage._COMMUTE) * Mileage._RATE;
    }
    public void setDest(Destination loc) {
        this.destination = loc;
    }
    public Destination getDest() {
        return this.destination;
    }
}