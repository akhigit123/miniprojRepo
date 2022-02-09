package org.proj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="insurance_plans")
public class InsuranceEntity {
	@Id
	@Column(name="plan_id")
	private Integer planId;

	@Column(name="plan_name")
	private String planName;

	@Column(name="holder_name")
	private String holderName;

	@Column(name="holder_ssn")
	private  Long holderSsn;

	@Column(name="plan_status")
	private String planStatus;
}
