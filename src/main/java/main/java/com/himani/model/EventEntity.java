package main.java.com.himani.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@Table(name = "event")
@Entity
public class EventEntity {


	    public EventEntity(String eventId, long eventDurationMs, boolean alert) {
	        this.eventId = eventId;
	        this.eventDurationMs = eventDurationMs;
	        this.alert = alert;
	    }

	    public EventEntity(String eventId, long eventDurationMs, String type, String host, boolean alert) {
	        this.eventId = eventId;
	        this.eventDurationMs = eventDurationMs;
	        this.type = type;
	        this.host = host;
	        this.alert = alert;
	    }

	    @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private long id;

	    @Column(name = "event_id", columnDefinition = "VARCHAR(10)",  nullable = false)
	    private String eventId;

	    @Column(name = "event_duration_ms", columnDefinition = "NUMERIC",  nullable = false)
	    private long eventDurationMs;

	    @Column(name = "event_type", columnDefinition = "VARCHAR(20)")
	    private String type;

	    @Column(name = "host", columnDefinition = "VARCHAR(20)")
	    private String host;

	    @Column(name = "alert", columnDefinition = "BOOLEAN DEFAULT FALSE", nullable = false)
	    private boolean alert;
	}
	

