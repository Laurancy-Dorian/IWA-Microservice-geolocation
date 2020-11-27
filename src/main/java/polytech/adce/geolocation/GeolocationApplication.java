package polytech.adce.geolocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import polytech.adce.geolocation.services.KafkaService;

@SpringBootApplication
public class GeolocationApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(GeolocationApplication.class, args);
	}


}
