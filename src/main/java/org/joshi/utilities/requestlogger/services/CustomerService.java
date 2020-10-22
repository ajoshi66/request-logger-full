package org.joshi.utilities.requestlogger.services;

import org.joshi.utilities.requestlogger.api.CustomerResponse;
import org.joshi.utilities.requestlogger.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	public CustomerResponse getCustomersByCity(String city) {
		CustomerResponse response = new CustomerResponse();
		if (city != null) {
			response.setCustomerList(repo.findByCity(city));
		}
		return response;
	}
}
