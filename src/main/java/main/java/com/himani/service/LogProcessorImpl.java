package main.java.com.himani.service;


import lombok.extern.slf4j.Slf4j;
import main.java.com.himani.Reader.LogReader;
import main.java.com.himani.dao.EventData;


import main.java.com.himani.model.EventEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class LogProcessorImpl implements LogProcessor {

	private final Logger logger = LoggerFactory.getLogger(EventProcessorServiceImpl.class);
   
		
	@Autowired
    private EventProcessorService eventProcessorService;

    @Autowired
    private LogReader<EventData> eventLogReader;
    


    private boolean run = false;

    
    @Override
    public void process() {
        run = true;
        logger.info("Starting the JsonEventLogProcessor");
        try {
            eventLogReader.open();
            while(run && eventLogReader.hasnext()) {
                try {
                    final EventData eventData = eventLogReader.read();
                    eventProcessorService.processEvent(eventData);
                     logger.info("Event added to processor {}", eventData);
                } catch (Exception e){
                    logger.error("Failed to process event", e);
                }
            }
            eventLogReader.close();
            logger.info("Finished processing events");
        } catch (Exception e) {
           logger.error("Failed to process events", e);
        }
    }

    @Override
    public void stop() {
        run = false;
    }

	

}
