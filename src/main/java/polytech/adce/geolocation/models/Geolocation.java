package polytech.adce.geolocation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="geolocation")
@IdClass(GeolocationId.class)
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Geolocation {

    @Id
    private String username;
    @Id
    private Date geolocation_timestamp;
    private double latitude;
    private double longitude;

    public Geolocation() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Date getGeolocation_timestamp() {
        return geolocation_timestamp;
    }

    public void setGeolocation_timestamp(Date geolocation_timestamp) {
        this.geolocation_timestamp = geolocation_timestamp;
    }

    public String toString() {
        return "User : " + this.username + " Lat : " + this.latitude + " Long : " + this.longitude + " timestamp : " + this.getGeolocation_timestamp();
    }
}
