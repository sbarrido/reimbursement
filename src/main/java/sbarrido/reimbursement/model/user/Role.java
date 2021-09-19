package sbarrido.reimbursement.model.user;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Role { 
    @Id
    @GeneratedValue
    private String id;

    private String role;

    public Role() {}

    public String getId() {
        return this.id;
    }
    public String getRole() {
        return this.role;
    }
    public void setRole(String val) {
        this.role = val;
    }
}