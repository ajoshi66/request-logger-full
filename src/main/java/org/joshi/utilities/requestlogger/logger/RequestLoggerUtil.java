package org.joshi.utilities.requestlogger.logger;

import java.util.List;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RequestLoggerUtil {

	@Value("${request.logging.enabled:true}")
	private boolean enabled;

	@Autowired
	private ApplicationContext context;
	
//	public void addLog(String message) {
//		RequestLoggerImpl logger = context.getBean(RequestLoggerImpl.class);
//		logger.log(message);
//	}
	
	public void addLog(String message, Object... args) {
		if (enabled) {
			RequestLoggerImpl logger = context.getBean(RequestLoggerImpl.class);
		 
			logger.log( MessageFormatter.arrayFormat(message, args).getMessage() );
		}
	}
	
	public List<String> getMessages() {
		if (enabled) {
			RequestLoggerImpl logger = context.getBean(RequestLoggerImpl.class);
			return logger.getMessages();
		} else {
			return null;
		}
	}
}
