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



}
