package main.java.com.himani.Reader;


import java.io.IOException;
import java.io.InputStreamReader;

import main.java.com.himani.dao.EventData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

@Component
public class LogReaderImpl implements LogReader<EventData>{
	
	private final Logger logger = LoggerFactory.getLogger(LogReaderImpl.class);
	
	private InputStreamReader inputReader;
	private Gson gson;
	private JsonStreamParser parser;
	
	@Value("${event.log.filepath}")
	private String filePath;

	@Override
	public void open() {
		logger.info("Opening file",filePath);	
		 this.inputReader = new InputStreamReader(TypeReference.class.getResourceAsStream(filePath));
	        this.parser = new JsonStreamParser(inputReader);
	        this.gson = new GsonBuilder().create();
	}

	@Override
	public boolean hasnext() {
		return parser.hasNext();
	}

	@Override
	public EventData read() {
		JsonElement jsonElement = parser.next();
		EventData event = gson.fromJson(jsonElement, EventData.class);
        logger.debug("Found event: {}", event);
        return event;
				}

	@Override
	public void close() throws IOException {
		
		logger.info("Closing Json log file");
		inputReader.close();
		
	}

	
	
}
