package main.java.com.himani;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventProcessorApplTest {

	@Test
	public void main(){
	  EventProcessorAppl.main(new String[]{});
	    }

}
