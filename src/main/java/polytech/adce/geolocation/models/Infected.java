package polytech.adce.geolocation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name="infected")
@IdClass(InfectedId.class)
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Infected {

    @Id
    private String username;
    @Id
    private Date date_start_infected;
    private Date date_end_infected;
    private boolean contact;

    public Infected() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate_start_infected() {
        return date_start_infected;
    }

    public void setDate_start_infected(Date date_start_infected) {
        this.date_start_infected = date_start_infected;
    }

    public Date getDate_end_infected() {
        return date_end_infected;
    }

    public void setDate_end_infected(Date date_end_infected) {
        this.date_end_infected = date_end_infected;
    }

    public boolean isContact() {
        return contact;
    }

    public void setContact(boolean contact) {
        this.contact = contact;
    }

    public String toString() {
        return "User Infected Id : " + this.username + " start : " + this.getDate_start_infected() + " end : " + this.getDate_end_infected() + " contact : " + this.isContact();
    }
}