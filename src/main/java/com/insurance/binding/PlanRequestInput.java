package com.insurance.binding;

import lombok.Data;


//@Data
public class PlanRequestInput {

	public String planName;
	
	public String planStatus;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	

	
	
}
