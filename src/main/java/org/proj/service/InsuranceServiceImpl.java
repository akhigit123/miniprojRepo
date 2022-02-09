package org.proj.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.bindings.request.InsuranceBindingRequest;
import org.proj.bindings.response.InsurancePlanResponse;
import org.proj.entity.InsuranceEntity;
import org.proj.repository.Insurancerepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private Insurancerepository insrepo;

	@Override
	public List<InsurancePlanResponse> searchplans(InsuranceBindingRequest request) {
		InsuranceEntity entity = new InsuranceEntity();

		if (request!=null&&request.getPlanname() != null && !request.getPlanname().equals(""))
			entity.setPlanName(request.getPlanname());

		if (request!=null&&request.getPlanStatus() != null && !request.getPlanStatus().equals(""))
			entity.setPlanStatus(request.getPlanStatus());
		
		Example<InsuranceEntity> of = Example.of(entity);
		List<InsuranceEntity> findAll = insrepo.findAll(of);
		List<InsurancePlanResponse> planres = new ArrayList();
		for (InsuranceEntity plan : findAll) {
			InsurancePlanResponse res = new InsurancePlanResponse();
			BeanUtils.copyProperties(plan, res);
			planres.add(res);
		}
		return planres;
	}
	public List<String> getuniquePlans(){
	return insrepo.getplansNames();
	}
	public List<String> getuniquestatus(){
		return insrepo.getplanStatus();
		}


}
