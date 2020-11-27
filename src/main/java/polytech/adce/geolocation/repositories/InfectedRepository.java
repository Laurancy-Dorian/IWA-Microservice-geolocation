package polytech.adce.geolocation.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import polytech.adce.geolocation.models.Infected;

import java.util.List;

public interface InfectedRepository extends JpaRepository<Infected, Long> {

    @Query("select i from infected i where i.username = ?1")
    List<Infected> findByUserId(String username);

}
