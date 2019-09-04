package main.java.com.himani.dao;

import java.util.List;

import main.java.com.himani.model.EventEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
	public interface EventRepository extends CrudRepository<EventEntity, Long> {

	    List<EventEntity> findAllByAlert(boolean alert);
}
