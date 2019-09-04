package main.java.com.himani.Reader;

import java.io.IOException;

import main.java.com.himani.dao.EventData;

public interface LogReader<T> {
void open();
boolean hasnext();
T read();
void close() throws IOException;
}
