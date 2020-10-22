package org.joshi.utilities.requestlogger.logger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class RequestLoggerImpl {
	
	List<String> messages = new ArrayList<>();
	
	public void log(String message) {
		messages.add(message);
	}
	
	public List<String> getMessages() {
		return messages;
	}
}
