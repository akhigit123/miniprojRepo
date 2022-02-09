package org.proj.service;

import java.util.List;

import org.proj.bindings.request.InsuranceBindingRequest;
import org.proj.bindings.response.InsurancePlanResponse;

public interface InsuranceService {
public  List<InsurancePlanResponse> searchplans(InsuranceBindingRequest request);
public List<String> getuniquePlans();
public List<String> getuniquestatus();
}
