package polytech.adce.geolocation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import polytech.adce.geolocation.models.Geolocation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


@Component
public class KafkaService {

    // --------------------------------------------------
    //                     Services
    // --------------------------------------------------

    private GeolocationService geolocationService;

    @Autowired
    public void setGeolocationService(GeolocationService geolocationService) {
        this.geolocationService = geolocationService;
    }

    // --------------------------------------------------
    //                     Variables
    // --------------------------------------------------

    @Value("${spring.kafka.bootstrap-servers}")
    public String bootstrap_servers;


    // --------------------------------------------------
    //                     Methods
    // --------------------------------------------------


//    @KafkaListener( groupId = "springConsumer", topics = "positions")
//    public void consume(String loc) {
//        System.out.println(loc);
//        String[] locations = loc.split(":");
//
//        Geolocation geoloc = new Geolocation();
//        try {
//            geoloc.setUsername(locations[0]);
//            geoloc.setLatitude(Double.parseDouble(locations[1]));
//            geoloc.setLongitude(Double.parseDouble(locations[2]));
//
//            DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);;
//            Date date = (Date)formatter.parse(locations[3] + ":" + locations[4] + ":" + locations[5]);
//            geoloc.setGeolocation_timestamp(date);
//
//            System.out.println(geoloc);
//
//            geolocationService.processLocation(geoloc);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }

    @KafkaListener( groupId = "springConsumer", topics = "positions")
    public void consume(String loc) {
        JsonParser parser = new BasicJsonParser();
        Map<String, Object> m = parser.parseMap(loc);
        Geolocation geoloc = new Geolocation();
        try {
            geoloc.setUsername(m.get("username").toString());
            geoloc.setLatitude(Double.parseDouble(m.get("latitude").toString()));
            geoloc.setLongitude(Double.parseDouble(m.get("longitude").toString()));

            DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);;
            Date date = (Date)formatter.parse(m.get("timestamp").toString());
            geoloc.setGeolocation_timestamp(date);

            System.out.println(geoloc);

            geolocationService.processLocation(geoloc);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
