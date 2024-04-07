package Spring_JDBC.Spring_JDBC;

import Spring_JDBC.Spring_JDBC.model.Alien;
import Spring_JDBC.Spring_JDBC.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		Alien alien = context.getBean(Alien.class);
        alien.setId(101);
		alien.setName("Navin");
		alien.setTech("Java");


		AlienRepo alienRepo = context.getBean(AlienRepo.class);
		alienRepo.save(alien);

		System.out.println(alienRepo.findAll());

	}


}
