package main.java.com.himani;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EventProcessorApplTest {

	@Test
	public void main(){
	  EventProcessorAppl.main(new String[]{});
	    }

}
