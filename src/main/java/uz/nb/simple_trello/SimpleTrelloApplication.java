package uz.nb.simple_trello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SimpleTrelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTrelloApplication.class, args);
    }

}
