package main.java.com.himani.service;

import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;
import main.java.com.himani.dao.EventData;
import main.java.com.himani.model.EventEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventProcessorServiceImpl implements EventProcessorService  {

	private final Logger logger = LoggerFactory.getLogger(EventProcessorServiceImpl.class);
	
	public static ConcurrentHashMap<String, EventData> incompleteEvents = new ConcurrentHashMap<String, EventData>(100);

    
    @PersistenceContext	
	private EntityManager entityManager;

    @Async
    public void processEvent(EventData eventData) {
        if (incompleteEvents.keySet().contains(eventData.getId())) {
            EventData existingEvent = incompleteEvents.get(eventData.getId());
            logger.debug("Processing event {} and existing event {}", eventData, existingEvent);

            long eventDuration = 0;
            switch (existingEvent.getState()) {
                case "STARTED": {
                    eventDuration = eventData.getTimestamp() - existingEvent.getTimestamp();
                    break;
                }
                case "FINISHED": {
                    eventDuration = existingEvent.getTimestamp() - eventData.getTimestamp();
                    break;
                }
            }


            incompleteEvents.remove(existingEvent.getId());
        }
        else {
            incompleteEvents.put(eventData.getId(), eventData);
            logger.debug("Adding event {} to incomplete events", eventData);
        }
    }

	
}
