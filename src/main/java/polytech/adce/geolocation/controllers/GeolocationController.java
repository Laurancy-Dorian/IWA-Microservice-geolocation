package polytech.adce.geolocation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polytech.adce.geolocation.models.Geolocation;
import polytech.adce.geolocation.models.Infected;
import polytech.adce.geolocation.repositories.GeolocationRepository;
import polytech.adce.geolocation.repositories.InfectedRepository;

import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/")
public class GeolocationController {

    // --------------------------------------------------
    //                     Autowire
    // --------------------------------------------------
    @Autowired
    private GeolocationRepository geolocationRepository;

    @Autowired
    private InfectedRepository infectedRepository ;

    // --------------------------------------------------
    //                     Variables
    // --------------------------------------------------
    @Value("${microservices.proximity.url}")
    private String proximityUrl;
    @Value("${microservices.proximity.port}")
    private String proximityPort;


    // --------------------------------------------------
    //                     Methods
    // --------------------------------------------------

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
        List<Infected> userInfections = infectedRepository.findByUserId(geolocation.getUsername());
        System.out.println(userInfections);
/**
        boolean infected = false;
        for (Infected i : userInfections) {
            if (i.getDate_end_infected() == null) {
                infected = true;
            }
        }

        if (infected) {
            // Store this loc in db
            geolocationRepository.save(geolocation);
        }

        // TODO Send a request to proximity microservice
        URL url;
        try {
            String requestUrl = proximityUrl + ":" + proximityPort;
            url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            ObjectOutputStream out = new ObjectOutputStream( con.getOutputStream() );
            out.writeObject(geolocation);
            out.close();
            // TODO SEND REQUEST

        } catch (Exception e) {
            System.out.println("Connexion with Proximity Microservice failed");
        }
**/
    }
}
