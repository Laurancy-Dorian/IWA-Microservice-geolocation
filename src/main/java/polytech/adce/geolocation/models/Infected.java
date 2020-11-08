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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Id
    private Date date_start_infected;
    private Date date_end_infected;
    private boolean contact;

    public Infected() {}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "User Infected Id : " + this.user_id + " start : " + this.getDate_start_infected() + " end : " + this.getDate_end_infected() + " contact : " + this.isContact();
    }
}