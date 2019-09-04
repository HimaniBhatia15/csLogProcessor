package main.java.com.himani.service;

import main.java.com.himani.dao.EventData;
import main.java.com.himani.model.EventEntity;

public interface EventProcessorService {

	public void processEvent(EventData eventData);

}
