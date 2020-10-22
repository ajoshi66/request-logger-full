package org.joshi.utilities.requestlogger.api;

import java.util.List;

import org.joshi.utilities.requestlogger.controllers.domain.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse extends BaseResponse {

	private List<Customer> customerList;
	
}
