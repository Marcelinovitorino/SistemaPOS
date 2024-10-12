
package Model;

import java.sql.Timestamp;

public class Supplier {
    
    private int id;
    private String name;
    private String phoneNumber;
    private int state;
    private Timestamp creationDate;

    // Constructors
    public Supplier() {
    }

    public Supplier(int id, String name, String phoneNumber, int state, Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.state = state;
        this.creationDate = creationDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", state=" + state +
                ", creationDate=" + creationDate +
                '}';
    }
}
