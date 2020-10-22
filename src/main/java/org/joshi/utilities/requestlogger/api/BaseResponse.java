package org.joshi.utilities.requestlogger.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {

	private List<String> logMessges;

}
