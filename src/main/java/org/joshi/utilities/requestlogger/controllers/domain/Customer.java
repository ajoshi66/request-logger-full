package org.joshi.utilities.requestlogger.controllers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
}
