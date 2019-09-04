package main.java.com.himani;

import main.java.com.himani.service.LogProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableTransactionManagement
@EntityScan("main.java.com.himani.model")
public class EventProcessorAppl implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(EventProcessorAppl.class);

	
	@Autowired
	private LogProcessor eventLogProcessor;
	
	public static void main(String args[]){
		
		logger.info("Helloooo");
		SpringApplication.run(EventProcessorAppl.class, args);
		
	}

	

	CommandLineRunner runner() {
		return args -> {
			eventLogProcessor.process();
		};
	}



	@Override
	public void run(String... args) throws Exception {
		logger.info("Application Stating");		
	}
}
//Field eventLogProcessor in main.java.com.Application.EventProcessorAppl required a bean of type
//'main.java.com.himani.service.LogProcessor' that could not be found.
