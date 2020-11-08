package polytech.adce.geolocation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import polytech.adce.geolocation.models.Geolocation;

public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {
}
