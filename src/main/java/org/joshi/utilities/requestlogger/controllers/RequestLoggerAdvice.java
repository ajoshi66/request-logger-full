package org.joshi.utilities.requestlogger.controllers;

import java.util.List;

import org.joshi.utilities.requestlogger.api.BaseResponse;
import org.joshi.utilities.requestlogger.logger.RequestLoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RequestLoggerAdvice implements ResponseBodyAdvice<BaseResponse> {
	
	@Autowired
	private RequestLoggerUtil reqLogger;

    @Override
    public boolean supports(final MethodParameter returnType, final Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public BaseResponse beforeBodyWrite(final BaseResponse body,
                                  final MethodParameter returnType,
                                  final MediaType selectedContentType,
                                  final Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  final ServerHttpRequest request,
                                  final ServerHttpResponse response) {
//        response.getHeaders().add("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.getHeaders().add("Pragma", "no-cache");
//        response.getHeaders().add("Expires", "0");
    	List<String> messages = reqLogger.getMessages();
    	body.setLogMessges(messages);
        return body;
    }
}