package guerrero.rocha.pricezara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
// Component scan por si la clase no esta en un paquete superior
@ComponentScan(basePackages = {"guerrero.rocha"})
// Para tener en cuenta tablas de un paquete especifico
@EnableJpaRepositories("guerrero.rocha.pricezara.infraestructure.outbound.database")
public class ZaraPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaraPricesApplication.class, args);
	}

}
