package org.joshi.utilities.requestlogger.logger;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class RequestLoggerUtil {

	@Value("${request.logging.enabled:true}")
	private boolean enabled;

	List<String> messages = new ArrayList<>();

	public void addLog(String message, Object... args) {
		if (enabled) {
			messages.add( MessageFormatter.arrayFormat(message, args).getMessage() );
		}
	}
	
	public List<String> getMessages() {
		if (enabled) {
			return messages;
		} else {
			return null;
		}
	}
}
