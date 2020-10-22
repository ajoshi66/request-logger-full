package org.joshi.utilities.requestlogger.controllers;

import org.joshi.utilities.requestlogger.api.CustomerResponse;
import org.joshi.utilities.requestlogger.logger.RequestLoggerUtil;
import org.joshi.utilities.requestlogger.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private RequestLoggerUtil reqLog;
	
	@GetMapping
	public @ResponseBody CustomerResponse getCustomers(@RequestParam String city) {
		log.info("Input city name: {}", city);
		//reqLog.addLog("Got the request to get list of customers belonging to " + city);
		reqLog.addLog("Got the request to get list of customers belonging to {}", city);
		CustomerResponse result = service.getCustomersByCity(city);
		if (result != null && result.getCustomerList() != null) {
			//reqLog.addLog("Got " + result.getCustomerList().size() + " customers belonging to " + city + " @" + System.currentTimeMillis());
			reqLog.addLog("Got {} customers belonging to {} @{}",  result.getCustomerList().size(),  city,  System.currentTimeMillis());
		} else {
			//reqLog.addLog("No customers found belonging to " + city + " @" + System.currentTimeMillis());
			reqLog.addLog("No customers found belonging to {} @{}", city, System.currentTimeMillis());
		}
		log.info("Output size of customer list: {}", (result.getCustomerList() == null?0:result.getCustomerList().size()));
		result.setLogMessges(reqLog.getMessages());
		return result;
	}

}
