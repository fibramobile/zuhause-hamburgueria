package br.com.brunobrasilweb.springadm;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SistemaApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
    }
	

    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
    }
}
