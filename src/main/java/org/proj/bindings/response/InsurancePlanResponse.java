package org.proj.bindings.response;

import lombok.Data;

@Data
public class InsurancePlanResponse {
	private Integer planId;
	private String planName;
	private String holderName;
	private  Long holderSsn;
	private String planStatus;

}
