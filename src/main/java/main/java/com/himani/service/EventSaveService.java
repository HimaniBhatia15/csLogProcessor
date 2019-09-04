package main.java.com.himani.service;

import main.java.com.himani.dao.EventRepository;
import main.java.com.himani.model.EventEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventSaveService {
	
	@Autowired
	private EventRepository eventRepo;
	
	@Transactional
	public EventEntity save(EventEntity ev){
		return eventRepo.save(ev);
	}

}
