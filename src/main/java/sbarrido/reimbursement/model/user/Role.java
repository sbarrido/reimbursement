package sbarrido.reimbursement.model.user;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role { 
    @Id
    @GeneratedValue
    private String id;
    @Enumerated(EnumType.ORDINAL)
    private UserRoles role;

    public Role() {}

    public String getId() {
        return this.id;
    }
    public UserRoles getRole() {
        return this.role;
    }
    public void setRole(UserRoles val) {
        this.role = val;
    }
}