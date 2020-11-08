package polytech.adce.geolocation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polytech.adce.geolocation.models.Geolocation;
import polytech.adce.geolocation.models.Infected;
import polytech.adce.geolocation.repositories.GeolocationRepository;
import polytech.adce.geolocation.repositories.InfectedRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class GeolocationController {
    @Autowired
    private GeolocationRepository geolocationRepository;

    @Autowired
    private InfectedRepository infectedRepository ;

    @GetMapping
    public List<Geolocation> list() {
        return geolocationRepository.findAll();
    }

    /**
     * Dev only
     * @return
     */
    @GetMapping("inf")
    public List<Infected> listInf() {
        return infectedRepository.findAll();
    }

    // TODO divide this method in a Services class
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void processLocation(@RequestBody final Geolocation geolocation) {
        System.out.println(geolocation);
        List<Infected> userInfections = infectedRepository.findByUserId(geolocation.getUser_id());
        System.out.println(userInfections);

        boolean infected = false;
        for (Infected i : userInfections) {
            if (i.getDate_end_infected() == null) {
                infected = true;
            }
        }

        if (infected) {
            // TODO Store this loc in db
        }

        // TODO Send a request to proximity microservice
    }
}
