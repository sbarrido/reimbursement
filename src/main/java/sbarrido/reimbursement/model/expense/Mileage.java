package sbarrido.reimbursement.model;
import java.util.*;

public class Mileage extends Reimbursement {
    public static final double _COMMUTE = 15.2;
    private static final double _RATE = 0.56;
    private AbstractMap.SimpleEntry<String, Double> destination;

    public Mileage(Date date, String description, AbstractMap.SimpleEntry<String, Double> destination) {
        setDate(date);
        setDesc(description);
        setDest(destination);
        setCost(destination.getValue());
    }
    
    public void setCost(double val) {
        this.cost = (val - Mileage._COMMUTE) * Mileage._RATE;
    }
    public void setDest(AbstractMap.SimpleEntry<String, Double> pair) {
        this.destination = pair;
    }
    public AbstractMap.SimpleEntry<String, Double> getDest() {
        return this.destination;
    }
}